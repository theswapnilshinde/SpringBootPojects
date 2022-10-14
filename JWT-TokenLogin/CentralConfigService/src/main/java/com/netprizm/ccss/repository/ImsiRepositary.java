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

	
//	Imsi findByIsreserved(Boolean boolean1 );
	//Boolean findByIsreserved(Boolean boolean1 );
	
	// @Query("SELECT e FROM  imsi e WHERE e.isreserved=?1")
//	 @Query("SELECT u from imsi u order by u.isreserved")
//	 List<Imsi> findByIsreserved(Boolean isreserved);
	 
	 @Transactional
	 @Modifying
	 @Query(value = "update cfg.imsi set environment=?,isreserved=?,runid=? where imsiid=?",nativeQuery = true)
	 void updateImsi(String environment,Boolean isreserved,Integer runid,Integer imsiid);
	
	 
//	 @Transactional
//	 @Modifying
//	 @Query("SELECT t FROM cfg.imsi t WHERE t.isreserved=false or Null")
//	 List<Imsi> findByIsreserved();
	 
	 List<Imsi> findByIsreserved(Boolean isreserved);
//	 List<Imsi> findByIsreservedNot(Boolean isreserved);


	Imsi findByrunid(Integer runid);
	Imsi findByenvironment(String environment);
	
	
//	 @Query(value = "SELECT t FROM cfg.imsi t WHERE iserserved = false;",nativeQuery = true)
//	 List<Imsi> findByruid();
	
}
