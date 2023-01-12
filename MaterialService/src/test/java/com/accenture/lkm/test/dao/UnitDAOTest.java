package com.accenture.lkm.test.dao;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.dao.UnitDAO;
import com.accenture.lkm.entity.MaterialTypeEntity;
import com.accenture.lkm.entity.UnitEntity;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitDAOTest {
private static final Logger logger = LoggerFactory.getLogger(UnitDAOTest.class);
	
    
	@Autowired
    private UnitDAO unitDAO;

	@Test
	public void notNullUnitDAOTest() {
		org.junit.Assert.assertNotNull(unitDAO);
	}
	@Test
	public void findByIdUnitDAOTest() {
		UnitEntity unitEntity = unitDAO.findOne("U002");
		String output = "Metres";
		org.junit.Assert.assertNotNull( unitEntity );
		org.junit.Assert.assertEquals("NOT THE SAME VENDOR NAME AS EXPECTED", output,unitEntity.getUnitName()); 	
	}
	@Test
	public void findByCategoryIdUnitDAOTest() {
		List<UnitEntity> materialTypeEntity = unitDAO.getUnitEntity("C001");
		org.junit.Assert.assertNotNull( materialTypeEntity );
	}
	

}
