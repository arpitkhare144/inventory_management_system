package com.accenture.lkm.services;

import java.util.Date;
import java.util.List;

import com.accenture.lkm.business.bean.PurchaseBean;

public interface PurchaseService {
	PurchaseBean addPurchaseDetails(PurchaseBean purchaseBean) throws Exception;
	List<PurchaseBean> getPurchaseDetailsByDate(Date fromDate,Date toDate);
}
