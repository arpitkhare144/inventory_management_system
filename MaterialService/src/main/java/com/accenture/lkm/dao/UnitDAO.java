package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.lkm.entity.MaterialCategoryEntity;
import com.accenture.lkm.entity.MaterialTypeEntity;
import com.accenture.lkm.entity.UnitEntity;

public interface UnitDAO extends JpaRepository<UnitEntity, String>{
	
	@Query("SELECT k FROM UnitEntity k WHERE k.categoryId=?1")
	public List<UnitEntity> getUnitEntity(String categoryId);
} 

