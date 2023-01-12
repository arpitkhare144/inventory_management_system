package com.accenture.lkm.service;

import java.util.List;

import com.accenture.lkm.business.bean.MaterialTypeBean;

public interface TypeService {
	List<MaterialTypeBean> getMaterialTypeByCategoryId(String categoryId);
	List<MaterialTypeBean> getMaterialTypes();
	
}
