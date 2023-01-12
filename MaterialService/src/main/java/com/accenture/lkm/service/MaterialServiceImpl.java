package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.dao.MaterialCategoryDAO;
import com.accenture.lkm.entity.MaterialCategoryEntity;

@Service
public class MaterialServiceImpl implements MaterialService {

	private static final Logger logger = LoggerFactory.getLogger(MaterialServiceImpl.class);

	

	 @Autowired
	 private MaterialCategoryDAO materialCategoryDAO;
	
	
	// Your Code Here
	

	/*
	 * Method - getMaterialCategoryById()
	 * Use MaterialCategoryDAO object findById method to fetch the entity by --> categoryId
	 * Check if the entity is present
	 * 		initialized the materialCategoryBean object
	 * 		copy the properties value from entity to materialCategoryBean object
	 * */
	
	@Override
	public MaterialCategoryBean getMaterialCategoryById(String categoryId) {
		
		MaterialCategoryBean materialCategoryBean = new MaterialCategoryBean();
		MaterialCategoryEntity materialCategoryEntity = null;
		materialCategoryEntity = materialCategoryDAO.getOne(categoryId);
		if(materialCategoryEntity!=null)
		{
			
			BeanUtils.copyProperties(materialCategoryEntity,materialCategoryBean);
	
		}
		
		return materialCategoryBean;
	}

	
	/*
	 * Method - getMaterialCategories()
	 * Use the MaterialCategoryDAO to get all the MaterialCategoryEntity objects
	 * Check if list is not empty then 
	 * 		Declare a MaterialCategoryBean object with null value
	 * 		Loop through all the material categories
	 * 			Initialize a new MaterialCategoryBean object 
	 * 			Copy each property value of entity object to bean object
	 * 			Add the bean object to the materialCategoryBeans list
	 * */

	
	@Override
	public List<MaterialCategoryBean> getMaterialCategories() {
		
		List<MaterialCategoryBean> materialCategoryBeans = new ArrayList<MaterialCategoryBean>();
		List<MaterialCategoryEntity> materialCategoryEntity = materialCategoryDAO.findAll();
		if(materialCategoryEntity!=null)
		{
			for (MaterialCategoryEntity materialCategoryEntity2 : materialCategoryEntity) {
				MaterialCategoryBean bean=new MaterialCategoryBean();
				BeanUtils.copyProperties(materialCategoryEntity2, bean);
				materialCategoryBeans.add(bean);
			}
		}
		return materialCategoryBeans;
	}


}	