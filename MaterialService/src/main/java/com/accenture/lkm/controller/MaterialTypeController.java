package com.accenture.lkm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.service.TypeService;

@RestController
public class MaterialTypeController {
	private static final Logger logger = LoggerFactory.getLogger(MaterialTypeController.class);
	
	@Autowired
	private TypeService typeService;
	
	@RequestMapping(value="/type", method=RequestMethod.GET)
	public String index() {
		return "Welcome to Spring Boot Material Type Service API!-dot is beautiful";
	}
	
	@RequestMapping(value="/type/controller/getMaterialTypes", method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaterialTypeBean>> getMaterialTypes() {
		
		// Your Code Here
		List<MaterialTypeBean> materialTypeBean = typeService.getMaterialTypes();
		return new ResponseEntity<List<MaterialTypeBean>>(materialTypeBean,HttpStatus.OK);
    }
	 
	@RequestMapping(value= "/type/controller/getMaterialTypeByCategoryId/{categoryId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaterialTypeBean>> getMaterialTypeById(@PathVariable("categoryId") String categoryId) {

		// Your Code Here
		List<MaterialTypeBean> materialTypeBean = typeService.getMaterialTypeByCategoryId(categoryId);
		return new ResponseEntity<List<MaterialTypeBean>>(materialTypeBean, HttpStatus.OK);
	}
	
		
		
		
 }
