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
import com.accenture.lkm.service.TypeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TypeServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(TypeServiceTest.class);
	
	@Autowired
	private TypeService typeService;
	
	@Test
	public void notNullTypeServiceTest() {
		Assert.assertNotNull(typeService);
	}
	
//	@Test
//	public void recordGetMaterialTypes() {
//		String typeName="Silk";
//		List<MaterialTypeBean> materialTypeBeanList = typeService.getMaterialTypes();
//		Integer size = materialTypeBeanList.size();
//		Integer actSize = 7;
//		Assert.assertNotNull(materialTypeBeanList);
//		Assert.assertEquals(actSize,size);
//	    MaterialTypeBean materialTypeBean = materialTypeBeanList.get(0);
//	    Assert.assertEquals("TYPE NAME NOT AS EXPECTED",typeName,materialTypeBean.getTypeName());
//	}
      
//	@Test
//	public void recordGetMaterialTypesByCategoryId() {
//		String categoryId="C001";
//		String typeName="Silk";
//		List<MaterialTypeBean> materialTypeBeanList = typeService.getMaterialTypeByCategoryId(categoryId);
//		Integer size = materialTypeBeanList.size();
//		Integer actSize = 2;
//		Assert.assertNotNull(materialTypeBeanList);
//		Assert.assertEquals(actSize,size);
//	    MaterialTypeBean materialTypeBean = materialTypeBeanList.get(0);
//	    Assert.assertEquals("TYPE NAME NOT AS EXPECTED",typeName,materialTypeBean.getTypeName());
//	}
}
