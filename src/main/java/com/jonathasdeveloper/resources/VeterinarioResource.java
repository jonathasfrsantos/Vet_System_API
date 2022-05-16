package com.jonathasdeveloper.resources;

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

import com.jonathasdeveloper.entities.Veterinario;
import com.jonathasdeveloper.repositories.VeterinarioRepository;
import com.jonathasdeveloper.services.VeterinarioService;

@RestController
@RequestMapping(value = "/veterinarios")
public class VeterinarioResource {
	
	@Autowired
	private VeterinarioService service;
	
	@Autowired
	private VeterinarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Veterinario>> findAll(){
		List<Veterinario> list = service.findAll();
		return ResponseEntity.ok().body(list);  
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Veterinario> findById(@PathVariable Long id){
		Veterinario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Veterinario> insert(@RequestBody Veterinario obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Veterinario> update(@PathVariable Long id, @RequestBody Veterinario obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
