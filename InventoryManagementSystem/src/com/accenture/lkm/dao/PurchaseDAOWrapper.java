package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.accenture.lkm.business.bean.PurchaseBean;

import com.accenture.lkm.entity.PurchaseEntity;

@Repository
@Transactional(value = "txManager")
public class PurchaseDAOWrapper {

	 @Autowired
     private DateRangeDao dateRangeDao;
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
