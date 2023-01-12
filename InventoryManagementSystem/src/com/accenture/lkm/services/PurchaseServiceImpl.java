package com.accenture.lkm.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.DateRangeBean;
import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.dao.DateRangeDao;
import com.accenture.lkm.dao.PurchaseDAO;
import com.accenture.lkm.dao.PurchaseDAOImpl;
import com.accenture.lkm.dao.PurchaseDAOWrapper;
import com.accenture.lkm.entity.PurchaseEntity;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@SuppressWarnings("unused")
	private static Logger LOGGER = Logger.getLogger(PurchaseServiceImpl.class);

	// Auto wire PurchaseDAO here
    @Autowired
    private PurchaseDAO purchaseDAO;
    @Autowired
    private PurchaseDAOWrapper purchaseDAOWrapper;

	/*
	 * @Autowired private PurchaseDAOImpl purchaseDAOImpl;
	 */
	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method is used to insert purchase details data into the purchase
	 * table. Also, this method will add a single row into the payment table
	 * with paid amount as zero to keep the track of the balance amount for a
	 * specific purchase.
	 * @param purchaseBean
	 * @return purchaseBean
	 * @throws Exception
	 */
	@Override
	public PurchaseBean addPurchaseDetails(PurchaseBean purchaseBean) throws Exception {
		return insertPurchaseDetails(purchaseBean);
	}

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method will be called by addPurchaseDetails method to insert the
	 * data into the Purchase table.
	 * @param purchaseBean
	 * @return purchaseBean
	 * @throws Exception
	 */
	private PurchaseBean insertPurchaseDetails(PurchaseBean purchaseBean) throws Exception {
		PurchaseEntity purchaseEntity = new PurchaseEntity();
		BeanUtils.copyProperties(purchaseBean, purchaseEntity); 
		String transactionId = transactionIdGenerator(purchaseBean.getVendorName(),purchaseBean.getMaterialCategoryName(),purchaseBean.getPurchaseDate());
		
		//String transactionId="Aditya";
		purchaseEntity.setTransactionId(transactionId);
		
		purchaseEntity.setStatus("Pending");
		
		PurchaseBean pb = new PurchaseBean();
		BeanUtils.copyProperties(purchaseDAO.savePurchaseDetail(purchaseEntity), pb);
		
		purchaseBean.setPurchaseId(pb.getPurchaseId());
		purchaseBean.setTransactionId(pb.getTransactionId());
		return purchaseBean;
	}

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method is used to generate the transaction id as per logic- P_first
	 * 3 characters of vendor name_purchase date in mmddyyyy format_first 3
	 * characters of material category purchased_primary key of purchase table
	 * 
	 * @param vendorName
	 * @param materialCategoryName
	 * @param purchaseDate
	 * @return String
	 */
	private String transactionIdGenerator(String vendorName, String materialCategoryName, Date purchaseDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strpurchaseDate=sdf.format(purchaseDate);
		String transacId = "P_"+vendorName.substring(0,3).toUpperCase()+"_"+strpurchaseDate+"_"+materialCategoryName.substring(0,3).toUpperCase()+"_";
		return transacId;

	}

	@Override
	public List<PurchaseBean> getPurchaseDetailsByDate(Date fromDate, Date toDate) {
	
		return purchaseDAOWrapper.getPurchaseDetailsByDate(fromDate, toDate);
	}


}
