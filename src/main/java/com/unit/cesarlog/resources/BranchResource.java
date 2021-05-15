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

import com.unit.cesarlog.domain.Branch;
import com.unit.cesarlog.services.BranchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Branch Endpoint", description = "Acesso aos endpoint da entidade Equipmaneto", tags = {"Branch Enpoints"})
@RestController
@RequestMapping(value="/branch")
public class BranchResource {
	
	@Autowired
	private BranchService service;
	
	@ApiOperation(value = "Busca todas os Filiais")
	@GetMapping
	public ResponseEntity<List<Branch>> findAll() {
		List<Branch> Branch = service.findAll();
		return ResponseEntity.ok().body(Branch);
	}
	
	@ApiOperation(value = "Busca um Filial pelo ID", notes = "Este endpoint faz a busca de uma Branch passando o Id como parâmetro da requisição.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Branch> findById(@PathVariable Integer id) {
		Branch obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere uma Filial enviando um json no corpo da requisição")
	@PostMapping
	public ResponseEntity<Branch> insert(@RequestBody Branch branch) {
		Branch obj = service.insert(branch);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@ApiOperation(value = "Atualiza uma Filial")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Branch> update(@RequestBody Branch branch, @PathVariable Integer id) {
		branch = service.update(branch, id);
		return ResponseEntity.ok().body(branch);
	}
	
	@ApiOperation(value = "Deleta um Filial passando o ID como parâmetro da requisição")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}


}
