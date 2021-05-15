package com.unit.cesarlog.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unit.cesarlog.domain.Project;
import com.unit.cesarlog.services.ProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Project", description = "Acesso aos endpoint da entidade Project", tags = {"Project"})
@RestController
@RequestMapping(value="/project")
public class ProjectResource {
	
	@Autowired
	private ProjectService service;
	
	@ApiOperation(value = "Busca todas os Filiais")
	@GetMapping
	public ResponseEntity<List<Project>> findAll() {
		List<Project> Project = service.findAll();
		return ResponseEntity.ok().body(Project);
	}
	
	@ApiOperation(value = "Busca um Projeto pelo ID", notes = "Este endpoint faz a busca de uma Project passando o Id como parâmetro da requisição.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Project> findById(@PathVariable Integer id) {
		Project obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere uma Projeto enviando um json no corpo da requisição")
	@PostMapping
	public ResponseEntity<Project> insert(@RequestBody Project project) {
		Project obj = service.insert(project);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@ApiOperation(value = "Atualiza uma Projeto")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Project> update(@RequestBody Project project, @PathVariable Integer id) {
		project = service.update(project, id);
		return ResponseEntity.ok().body(project);
	}
	
	/*
	 * @ApiOperation(value =
	 * "Deleta um Projeto passando o ID como parâmetro da requisição")
	 * 
	 * @DeleteMapping(value = "/{id}") public ResponseEntity<Void>
	 * delete(@PathVariable Integer id) { service.delete(id); return
	 * ResponseEntity.noContent().build(); }
	 */
	

}
