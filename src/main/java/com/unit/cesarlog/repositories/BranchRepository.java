package com.unit.cesarlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unit.cesarlog.domain.Branch;


@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer>  {

}