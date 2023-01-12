package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.entity.PurchaseEntity;

/**
 * <br/>
 * CLASS DESCRIPTION: <br/>
 * Implementation class for PurchaseDAO to perform the CRUD operation on
 * Purchase table <br/>
 *
 */
@Repository

public class PurchaseDAOImpl implements PurchaseDAO {
	
	@SuppressWarnings("unused")
	private static Logger LOGGER = Logger.getLogger(PurchaseDAOImpl.class);

	// Auto wire EntityManagerFactory here
      @Autowired
      private EntityManagerFactory entityManagerFactory;
      @Autowired
      private DateRangeDao dateRangeDao;
      
      
	/*
	 * This method inserts the Purchase Data into the Purchase table.
	 * 
	 * @param purchaseEntity
	 * 
	 * @return PurchaseEntity
	 */
	@Override
	public PurchaseEntity savePurchaseDetail(PurchaseEntity purchaseEntity) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(purchaseEntity);
		entityManager.getTransaction().commit();
		String transacId = ((purchaseEntity.getTransactionId())+(purchaseEntity.getPurchaseId().toString()));
		entityManager.getTransaction().begin();
		purchaseEntity.setTransactionId(transacId);
		entityManager.merge(purchaseEntity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return purchaseEntity;
	}
	public List<PurchaseBean> getPurchaseDetailsByDate(Date fromDate,Date toDate)
	{
		List<PurchaseEntity> entities=dateRangeDao.getPurchaseDetailsByDate(fromDate, toDate);
		List<PurchaseBean> beans=new ArrayList<PurchaseBean>();
		for(PurchaseEntity entity:entities) {
			PurchaseBean bean=convertEntityToBean(entity);
			beans.add(bean);
		}
		return beans;
		
	}
	public static PurchaseBean convertEntityToBean(PurchaseEntity entity) {
		PurchaseBean bean = new PurchaseBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}

}
