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

import com.unit.cesarlog.domain.EquipmentStatus;
import com.unit.cesarlog.services.EquipmentStatusService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Equipment Status", description = "Acesso aos endpoint da entidade Status de Equipamento", tags = {"Equipment Status"})
@RestController
@RequestMapping(value="/equipment-status")
public class EquipmentStatusResource {
	
	@Autowired
	private EquipmentStatusService service;
	
	@ApiOperation(value = "Busca todos os Status de Equipamentos")
	@GetMapping
	public ResponseEntity<List<EquipmentStatus>> findAll() {
		List<EquipmentStatus> equipmentStatus = service.findAll();
		return ResponseEntity.ok().body(equipmentStatus);
	}
	
	@ApiOperation(value = "Busca um Status de Equipamento pelo ID", notes = "Este endpoint faz a busca de um Status de Equipamento passando o Id como parâmetro da requisição.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<EquipmentStatus> findById(@PathVariable Integer id) {
		EquipmentStatus obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere uma Status de Equipamento enviando um json no corpo da requisição")
	@PostMapping
	public ResponseEntity<EquipmentStatus> insert(@RequestBody EquipmentStatus equipmentStatus) {
		EquipmentStatus obj = service.insert(equipmentStatus);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@ApiOperation(value = "Atualiza um Status de Equipamento")
	@PutMapping(value = "/{id}")
	public ResponseEntity<EquipmentStatus> update(@RequestBody EquipmentStatus equipmentStatus, @PathVariable Integer id) {
		equipmentStatus = service.update(equipmentStatus, id);
		return ResponseEntity.ok().body(equipmentStatus);
	}
	
	@ApiOperation(value = "Deleta um Status de Equipamento passando o ID como parâmetro da requisição")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}


}
