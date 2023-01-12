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

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.service.MaterialService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(MaterialServiceTest.class);
	
	@Autowired
	private MaterialService materialService;
	
	
	@Test
	public void notNullMaterialServiceTest() {
		Assert.assertNotNull(materialService);
	}
	
	//@Test
	public void dontKnowWhatToDoAboutThis()
	{
		
		String categoryId = "C001";
		MaterialCategoryBean materialCategoryBean = materialService.getMaterialCategoryById(categoryId);	
		Assert.assertNotNull(materialCategoryBean);
	}
	
	//
	//
	//
	//
	//
	//
	//
	//
	///
	//
	
	
	
	
	
	
	
	
	//@Test
	public void recordGetMaterialCategoryById() {
		String categoryId = "C001";
		String categoryName="Thread";
		MaterialCategoryBean materialCategoryBean = materialService.getMaterialCategoryById(categoryId);
		Assert.assertNotNull(materialCategoryBean);
		Assert.assertEquals("CATEGORY Name NOT AS EXPECTED",categoryName, materialCategoryBean.getCategoryName());
	}
	
	@Test
	public void recordGetMaterialCategories() {
		String categoryName="Thread";
		List<MaterialCategoryBean> materialCategoryBeanList = materialService.getMaterialCategories();
		Integer size = materialCategoryBeanList.size();
		Integer actSize = 3;
		Assert.assertNotNull(materialCategoryBeanList);
		Assert.assertEquals(actSize, size);
		MaterialCategoryBean materialCategoryBean = materialCategoryBeanList.get(0);
		Assert.assertEquals("CATEGORY NAME NOT AS EXPECTED", categoryName, materialCategoryBean.getCategoryName());
	}
	
	
	
	
}
