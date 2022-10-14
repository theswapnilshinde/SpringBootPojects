package com.netprizm.app.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netprizm.app.entity.Ues;
@Repository
public interface UesRepo extends JpaRepository<Ues, Integer> {

}
