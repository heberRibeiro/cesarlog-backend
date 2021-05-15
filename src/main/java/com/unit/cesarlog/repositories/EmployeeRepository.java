package com.unit.cesarlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unit.cesarlog.domain.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>  {

}