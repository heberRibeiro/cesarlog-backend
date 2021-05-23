package com.unit.cesarlog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unit.cesarlog.domain.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer>  {
	
	List<Equipment> findEquipmentByEmployeeId(Integer employeeID);

}
