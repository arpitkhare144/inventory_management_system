package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.lkm.entity.MaterialCategoryEntity;
import com.accenture.lkm.entity.MaterialTypeEntity;

public interface MaterialTypeDAO extends JpaRepository<MaterialTypeEntity, String>{
	@Query("SELECT k FROM MaterialTypeEntity k WHERE k.categoryId=?1")
	public List<MaterialTypeEntity> getTypeEntity(String categoryId);
} 


