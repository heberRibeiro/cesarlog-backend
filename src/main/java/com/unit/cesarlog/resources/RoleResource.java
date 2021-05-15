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

import com.unit.cesarlog.domain.Role;
import com.unit.cesarlog.services.RoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Role", description = "Acesso aos endpoints da entidade Role", tags = {"Role Enpoints"})
@RestController
@RequestMapping(value="/role")
public class RoleResource {
	
	@Autowired
	private RoleService service;
	
	@ApiOperation(value = "Busca todas os Papeis")
	@GetMapping
	public ResponseEntity<List<Role>> findAll() {
		List<Role> Role = service.findAll();
		return ResponseEntity.ok().body(Role);
	}
	
	@ApiOperation(value = "Busca um Papel pelo ID", notes = "Este endpoint faz a busca de um Papel passando o Id como parâmetro da requisição.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Role> findById(@PathVariable Integer id) {
		Role obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere uma Papel enviando um json no corpo da requisição")
	@PostMapping
	public ResponseEntity<Role> insert(@RequestBody Role role) {
		Role obj = service.insert(role);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@ApiOperation(value = "Atualiza uma Papel")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Role> update(@RequestBody Role role, @PathVariable Integer id) {
		role = service.update(role, id);
		return ResponseEntity.ok().body(role);
	}
	
	@ApiOperation(value = "Deleta um Papel passando o ID como parâmetro da requisição")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
