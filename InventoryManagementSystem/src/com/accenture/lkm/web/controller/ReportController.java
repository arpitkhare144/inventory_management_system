package com.accenture.lkm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.accenture.lkm.business.bean.DateRangeBean;
import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.services.PurchaseService;

@Controller
public class ReportController {

	@Autowired
	private PurchaseService purchaseService;
	
	@RequestMapping(value = "/loadPurchaseReport.html")
	public ModelAndView loadPurchaseReport() {
		return new ModelAndView("PurchaseReport","dateRangeBean",new DateRangeBean());
	}
	
	@RequestMapping(value = "/getDetails.html", method = RequestMethod.POST)
	public ModelAndView getPurchaseDetailsByDate(@ModelAttribute("dateRangeBean") DateRangeBean dateRange) {
		ModelAndView mv=new ModelAndView();
		List<PurchaseBean> purchase=purchaseService.getPurchaseDetailsByDate(dateRange.getFromDate(), dateRange.getToDate());
		mv.setViewName("ShowDetails");
		mv.addObject("purchase", purchase);
		return mv;
	}
	
	
}
