package com.accenture.lkm.test.dao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.dao.MaterialCategoryDAO;
import com.accenture.lkm.entity.MaterialCategoryEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialCategoryDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MaterialCategoryDAOTest.class);
	
    
	@Autowired
    private MaterialCategoryDAO materialCategoryDAO;

	@Test
	public void notNullVendorDAOTest() {
		org.junit.Assert.assertNotNull(materialCategoryDAO);
	}
	@Test
	public void findByIdVendorDAOTest() {
		MaterialCategoryEntity materialCategoryEntity = materialCategoryDAO.findOne("C001");
		String output = "Thread";
		org.junit.Assert.assertNotNull( materialCategoryEntity );
		org.junit.Assert.assertEquals("NOT THE SAME VENDOR NAME AS EXPECTED", output,materialCategoryEntity.getCategoryName()); 	
	}

}
