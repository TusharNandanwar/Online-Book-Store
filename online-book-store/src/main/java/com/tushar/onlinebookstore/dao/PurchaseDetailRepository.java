package com.tushar.onlinebookstore.dao;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tushar.onlinebookstore.entity.PurchaseDetail;
import com.tushar.onlinebookstore.entity.PurchaseDetailId;
import com.tushar.onlinebookstore.entity.PurchaseHistory;

@RepositoryRestResource
public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail, PurchaseDetailId> {

	
	@Query("from PurchaseDetail where purchaseHistory = ?1")
	Set<PurchaseDetail> findAllByHistory(PurchaseHistory purchaseHistory);

}
