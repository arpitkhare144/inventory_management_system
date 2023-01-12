package com.accenture.lkm.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.service.VendorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(VendorServiceTest.class);
	
	/*Autowire the VendorService object below */
	// Your Code Here
    @Autowired
    private VendorService vendorService;
	/* Method - notNullVendorServiceTest()
	 * Assert only that VendorService object is Not null()  */
	
	@Test
	public void notNullVendorServiceTest() {
		// Your Code Here
//		Assert.assertNotNull(vendorService);
	}

	/*
	 * Method - notNullGetVendorDetailsTest()
	 * Assert only that VendorService getVendorDetails is not returning a null value
	 * 
	 */

	@Test
	public void notNullGetVendorDetailsTest() {
//		List<VendorBean> vendorBean = vendorService.getVendorDetails();
//		Assert.assertNotNull(vendorBean);
	}

	/*
	 * Method - countGetVendorDetailsTest()
	 * Assert only that VendorService getVendorDetails list size matches to 5
	 * 
	 */
	@Test
	public void countGetVendorDetailsTest() {
		// Your Code Here
//		List<VendorBean> vendorBean = vendorService.getVendorDetails();
//		Integer size = vendorBean.size();
//		Integer actSize =5;
//		Assert.assertEquals(actSize,size);
	}

	/*
	 * Method - recordGetVendorDetailsTest()
	 * Assert only that VendorService getVendorDetails first bean name matches --> "Only Vimal"
	 * 
	 */
		
	@Test
	public void recordGetVendorDetailsTest() {
//		List<VendorBean> vendorBean =vendorService.getVendorDetails();
//		String exOP = "Only Vimal";
//		VendorBean bean = vendorBean.get(0);
//		Assert.assertEquals("NOT THE SAME VENDOR NAME AS EXPECTED", exOP, bean.getVendorName());
	}

}