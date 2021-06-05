package com.unit.cesarlog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unit.cesarlog.domain.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer>  {
	
	List<Equipment> findEquipmentByBranchId(Integer branchID);
	List<Equipment> findEquipmentByProjectId(Integer projectID);
	List<Equipment> findEquipmentByEmployeeId(Integer employeeID);
	
	@Query(value="SELECT e FROM Equipment e WHERE e.branchId = :branchId OR e.projectId = :projectId")
	List<Equipment> findEquipmentByBranchIdOrProjectIdEmployeeId(@Param("branchId") Integer branchId, 
			@Param("projectId") Integer projectId);

}
