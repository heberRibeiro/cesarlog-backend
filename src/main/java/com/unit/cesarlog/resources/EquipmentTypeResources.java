package com.unit.cesarlog.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unit.cesarlog.domain.EquipmentType;
import com.unit.cesarlog.services.EquipmentTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Equipment Type", description = "Acesso aos endpoint da entidade Tipo de Equipamento", tags = {"Equipment Type Enpoints"})
@RestController
@RequestMapping(value="/equipment-type")
public class EquipmentTypeResources {
	
	@Autowired
	private EquipmentTypeService service;
	
	@ApiOperation(value = "Busca todos os Tipos de Equipamentos")
	@GetMapping
	public ResponseEntity<List<EquipmentType>> findAll() {
		List<EquipmentType> equipmentType = service.findAll();
		return ResponseEntity.ok().body(equipmentType);
	}
	
	@ApiOperation(value = "Busca um Tipo de Equipamento pelo ID", notes = "Este endpoint faz a busca de uma EquipmentTypeo passando o Id como parâmetro da requisição.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<EquipmentType> findById(@PathVariable Integer id) {
		EquipmentType obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere uma Tipo de Equipamento enviando um json no corpo da requisição")
	@PostMapping
	public ResponseEntity<EquipmentType> insert(@RequestBody EquipmentType equipmentType) {
		EquipmentType obj = service.insert(equipmentType);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@ApiOperation(value = "Atualiza um Tipo de Equipamento")
	@PutMapping(value = "/{id}")
	public ResponseEntity<EquipmentType> update(@RequestBody EquipmentType equipmentType, @PathVariable Integer id) {
		equipmentType = service.update(equipmentType, id);
		return ResponseEntity.ok().body(equipmentType);
	}
	
	@ApiOperation(value = "Deleta um Tipo de Equipamento passando o ID como parâmetro da requisição")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
