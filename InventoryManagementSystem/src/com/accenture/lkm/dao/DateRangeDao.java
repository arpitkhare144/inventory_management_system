package com.accenture.lkm.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.PurchaseEntity;
@RepositoryDefinition(idClass = Integer.class, domainClass = PurchaseEntity.class)
@Transactional(value = "txManager")
public interface DateRangeDao {
	@Query("select k from PurchaseEntity k where k.purchaseDate>?1 and k.purchaseDate<?2")
	List<PurchaseEntity> getPurchaseDetailsByDate(Date fromDate,Date toDate);
}
