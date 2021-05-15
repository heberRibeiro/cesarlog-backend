package com.unit.cesarlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unit.cesarlog.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>  {

}