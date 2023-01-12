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

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.controller.MaterialTypeController;
import com.accenture.lkm.service.TypeService;

@RunWith(SpringRunner.class)
@WebMvcTest(MaterialTypeController.class)
public class TypeControllerTest {

private static final Logger logger = LoggerFactory.getLogger(TypeControllerTest.class);
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TypeService   typeServiceMock;
	
	
	@Test
	public void indexTypeControllerTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/type")).andExpect(status().isOk())
				.andExpect(content().string("Welcome to Spring Boot Material Type Service API!-dot is beautiful"));
	}
	
	@Test
	public void typeListMaterialTypeControllerTest() throws Exception {

		
		  MaterialTypeBean bean = new MaterialTypeBean("U001","Thread","C001"); 
		  List<MaterialTypeBean> materialTypeBean= new ArrayList<>(); 
		  materialTypeBean.add(bean);
		  
		  when(typeServiceMock.getMaterialTypes()).thenReturn(materialTypeBean);
		  
		  mockMvc.perform(MockMvcRequestBuilders.get("/type/controller/getMaterialTypes"))
		  .andExpect(status().isOk())
		  .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) 
		  
		  // check size of json object 
		  .andExpect(jsonPath("$", hasSize(1)))
		  
		  //check if the json node exsits
		  .andExpect(jsonPath("$[0].typeId").exists())
		  .andExpect(jsonPath("$[0].typeName").exists())
		  .andExpect(jsonPath("$[0].categoryId").exists())
		  //check the type of json node
		  .andExpect(jsonPath("$[0].typeId").isString())
		  .andExpect(jsonPath("$[0].typeName").isString())
		  .andExpect(jsonPath("$[0].categoryId").isString())
		  
		  //check the return value 
		  .andExpect(jsonPath("$[0].typeId").value(bean.getTypeId()))	
		  .andExpect(jsonPath("$[0].typeName").value(bean.getTypeName()))
		  .andExpect(jsonPath("$[0].categoryId").value(bean.getCategoryId()));
		  	  		

	}

}
