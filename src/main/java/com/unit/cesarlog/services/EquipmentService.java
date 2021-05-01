package com.unit.cesarlog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unit.cesarlog.domain.Equipment;
import com.unit.cesarlog.repositories.EquipmentRepository;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository repository;
	
	public List<Equipment> findAll() {
		return repository.findAll();
	}
}
