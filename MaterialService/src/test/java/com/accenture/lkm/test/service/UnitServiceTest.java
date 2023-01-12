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

import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.service.UnitService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitServiceTest {
	
private static final Logger logger = LoggerFactory.getLogger(UnitServiceTest.class);
	
	@Autowired
	private UnitService unitService;
	
	@Test
	public void notNullUnitServiceTest() {
		Assert.assertNotNull(unitService);
	}
	
	@Test
	public void recordGetUnits() {
		String typeName="Metres";
		List<UnitBean> unitBeanList = unitService.getUnits();
		Integer size = unitBeanList.size();
		Integer actSize = 5;
		Assert.assertNotNull(unitBeanList);
		Assert.assertEquals(actSize,size);
	    UnitBean unitBean = unitBeanList.get(0);
	    Assert.assertEquals("TYPE NAME NOT AS EXPECTED",typeName,unitBean.getUnitName());
	}
	@Test
	public void recordGetUnitsByCategoryId() {
		String categoryId = "C001";
		String typeName="Metres";
		List<UnitBean> unitBeanList = unitService.getUnitByCategoryId(categoryId);
		Integer size = unitBeanList.size();
		Integer actSize = 2;
		Assert.assertNotNull(unitBeanList);
		Assert.assertEquals(actSize,size);
	    UnitBean unitBean = unitBeanList.get(0);
	    Assert.assertEquals("TYPE NAME NOT AS EXPECTED",typeName,unitBean.getUnitName());
	}
}
