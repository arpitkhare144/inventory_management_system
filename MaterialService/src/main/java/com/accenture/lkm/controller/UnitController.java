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

import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.service.UnitService;
import com.accenture.lkm.service.UnitServiceImpl;

@RestController
public class UnitController {
	private static final Logger logger = LoggerFactory.getLogger(UnitController.class);
	
	@Autowired
	private UnitService unitService;
	
	@RequestMapping(value="/unit", method=RequestMethod.GET)
	public String index() {
		return "Welcome to Spring Boot Unit Service API!-dot is beautiful";
	}
	
	@RequestMapping(value="/unit/controller/getUnit", method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UnitBean>> getUnits() {
		
		// Your Code Here
		List<UnitBean> unitBean = unitService.getUnits();
		return new ResponseEntity<List<UnitBean>>(unitBean,HttpStatus.OK);
    }
	 
	@RequestMapping(value= "/unit/controller/getUnitByCategoryId/{categoryId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UnitBean>> getMaterialTypeById(@PathVariable("categoryId") String categoryId) {

		// Your Code Here
		List<UnitBean> unitBean = unitService.getUnitByCategoryId(categoryId);
		return new ResponseEntity<List<UnitBean>>(unitBean, HttpStatus.OK);
	}

}
