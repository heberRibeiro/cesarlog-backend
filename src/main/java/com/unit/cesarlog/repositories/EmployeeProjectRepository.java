package com.unit.cesarlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unit.cesarlog.domain.EmployeeProject;

@Repository
public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Integer>  {

}