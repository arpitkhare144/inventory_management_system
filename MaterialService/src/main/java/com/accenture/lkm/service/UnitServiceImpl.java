package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.dao.MaterialTypeDAO;
import com.accenture.lkm.dao.UnitDAO;
import com.accenture.lkm.entity.UnitEntity;
@Service
public class UnitServiceImpl implements UnitService{
	
    private static final Logger logger = LoggerFactory.getLogger(UnitServiceImpl.class);
	
	@Autowired
	private UnitDAO unitDAO;


	@Override
	public List<UnitBean> getUnitByCategoryId(String categoryId) {
		// TODO Auto-generated method stub
		List<UnitBean> unitBean = new ArrayList();
		List<UnitEntity> unitEntity = new ArrayList();
		unitEntity=unitDAO.getUnitEntity(categoryId);
		if(unitEntity!=null)
		{
		for (UnitEntity unitEntity2 : unitEntity) {
			UnitBean bean = new UnitBean();
			BeanUtils.copyProperties(unitEntity2,bean);	
            unitBean.add(bean);
		}	
		}
		return unitBean;
	}

	@Override
	public List<UnitBean> getUnits() {
		// TODO Auto-generated method stub
		List<UnitBean> bean = new ArrayList<UnitBean>();
		List<UnitEntity> entity = unitDAO.findAll();
		for (UnitEntity unitEntity : entity) {
			UnitBean beanTemp = new UnitBean();
			BeanUtils.copyProperties(unitEntity, beanTemp);
			bean.add(beanTemp);
		}
		return bean;
	}

}
