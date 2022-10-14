package com.netprizm.ccss.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.netprizm.ccss.models.Imsi;
@Repository
public interface ImsiRepositary extends JpaRepository<Imsi, Integer> {

	 
	 @Transactional
	 @Modifying
	 @Query(value = "update cfg.imsi set environment=?,isreserved=?,runid=? where imsiid=?",nativeQuery = true)
	 void updateImsi(String environment,Boolean isreserved,Integer runid,Integer imsiid);
		 
	 List<Imsi> findByIsreserved(Boolean isreserved);

	Imsi findByrunid(Integer runid);
	Imsi findByenvironment(String environment);

	
}
