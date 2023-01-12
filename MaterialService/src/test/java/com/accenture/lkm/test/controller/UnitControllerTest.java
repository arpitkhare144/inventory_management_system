package com.accenture.lkm.test.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.controller.UnitController;
import com.accenture.lkm.service.UnitService;

@RunWith(SpringRunner.class)
@WebMvcTest(UnitController.class)
public class UnitControllerTest {
private static final Logger logger = LoggerFactory.getLogger(TypeControllerTest.class);
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UnitService   unitServiceMock;
	
	
	@Test
	public void indexUnitControllerTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/unit")).andExpect(status().isOk())
				.andExpect(content().string("Welcome to Spring Boot Unit Service API!-dot is beautiful"));
	}

	@Test
	public void unitListMaterialUnitControllerTest() throws Exception {

		
		  UnitBean bean = new UnitBean("U001","Thread","C001"); 
		  List<UnitBean> unitBean= new ArrayList<>(); 
		  unitBean.add(bean);
		  
		  when(unitServiceMock.getUnits()).thenReturn(unitBean);
		  
		  mockMvc.perform(MockMvcRequestBuilders.get("/unit/controller/getUnit"))
		  .andExpect(status().isOk())
		  .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) 
		  
		  // check size of json object 
		  .andExpect(jsonPath("$", hasSize(1)))
		  
		  //check if the json node exsits
		  .andExpect(jsonPath("$[0].unitId").exists())
		  .andExpect(jsonPath("$[0].unitName").exists())
		  .andExpect(jsonPath("$[0].categoryId").exists())
		  //check the type of json node
		  .andExpect(jsonPath("$[0].unitId").isString())
		  .andExpect(jsonPath("$[0].unitName").isString())
		  .andExpect(jsonPath("$[0].categoryId").isString())
		  
		  //check the return value 
		  .andExpect(jsonPath("$[0].unitId").value(bean.getUnitId()))	
		  .andExpect(jsonPath("$[0].unitName").value(bean.getUnitName()))
		  .andExpect(jsonPath("$[0].categoryId").value(bean.getCategoryId()));
		  	  		

	}


}
