package com.accenture.lkm.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.dao.MaterialTypeDAO;
import com.accenture.lkm.entity.MaterialTypeEntity;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialTypeDAOTest {
    private static final Logger logger = LoggerFactory.getLogger(MaterialTypeDAOTest.class);
	
    
	@Autowired
    private MaterialTypeDAO materialTypeDAO;

	@Test
	public void notNullTypeDAOTest() {
		org.junit.Assert.assertNotNull(materialTypeDAO);
	}
//	@Test
//	public void findByIDTypeDAOTest() {
//		MaterialTypeEntity materialTypeEntity = materialTypeDAO.findOne("T002");
//		String output = "Silk";
//		org.junit.Assert.assertNotNull( materialTypeEntity );
//		org.junit.Assert.assertEquals("NOT THE SAME VENDOR NAME AS EXPECTED", output,materialTypeEntity.getTypeName()); 	
//	}
	@Test
	public void findByCategoryIdTypeDAOTest() {
		List<MaterialTypeEntity> materialTypeEntity = materialTypeDAO.getTypeEntity("C001");
		org.junit.Assert.assertNotNull( materialTypeEntity );
	}

}
