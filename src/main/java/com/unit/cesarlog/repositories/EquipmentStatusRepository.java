package com.unit.cesarlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unit.cesarlog.domain.EquipmentStatus;

@Repository
public interface EquipmentStatusRepository extends JpaRepository<EquipmentStatus, Integer>  {

}