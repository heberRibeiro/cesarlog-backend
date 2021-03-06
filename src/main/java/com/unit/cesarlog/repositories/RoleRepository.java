package com.unit.cesarlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unit.cesarlog.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>  {

}