package com.netprizm.app.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netprizm.app.entity.TowerData;
@Repository
public interface TowerRepositary extends JpaRepository<TowerData, Integer> {

}
