package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.dao.MaterialTypeDAO;
import com.accenture.lkm.entity.MaterialCategoryEntity;
import com.accenture.lkm.entity.MaterialTypeEntity;

@Service
public class TypeServiceImpl implements TypeService {
	
	private static final Logger logger = LoggerFactory.getLogger(TypeServiceImpl.class);
	
	@Autowired
	private MaterialTypeDAO materialTypeDAO;
	
	
	@Override
	public List<MaterialTypeBean> getMaterialTypeByCategoryId(String categoryId) {
		
		// TODO Auto-generated method stub
		List<MaterialTypeBean> materialTypeBean = new ArrayList();
		List<MaterialTypeEntity> materialTypeEntity = materialTypeDAO.getTypeEntity(categoryId);
		
		for (MaterialTypeEntity materialTypeEntity2 : materialTypeEntity)
		{
			MaterialTypeBean bean = new MaterialTypeBean();
			BeanUtils.copyProperties(materialTypeEntity2, bean);
			materialTypeBean.add(bean);
		}
			return materialTypeBean;
	}
	
	@Override
	public List<MaterialTypeBean> getMaterialTypes() {
		// TODO Auto-generated method stub
		List<MaterialTypeBean> bean = new ArrayList<MaterialTypeBean>();
		List<MaterialTypeEntity> entity = materialTypeDAO.findAll();
		if(entity!=null){System.out.println("hii iam working");}
		for (MaterialTypeEntity materialTypeEntity : entity) {
			MaterialTypeBean beanTemp = new MaterialTypeBean();
			BeanUtils.copyProperties(materialTypeEntity, beanTemp);
			bean.add(beanTemp);
		}
		System.out.println(bean);
		return bean;
	}

}
