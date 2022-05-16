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

import com.jonathasdeveloper.entities.Vacina;
import com.jonathasdeveloper.repositories.VacinaRepository;
import com.jonathasdeveloper.services.VacinaService;

@RestController
@RequestMapping(value = "/vacinas")
public class VacinaResource {
	
	@Autowired
	private VacinaService service;
	
	@Autowired
	private VacinaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Vacina>> findAll(){
		List<Vacina> list = service.findAll();
		return ResponseEntity.ok().body(list);  
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Vacina> findById(@PathVariable Long id){
		Vacina obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Vacina> insert(@RequestBody Vacina obj) {
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
	public ResponseEntity<Vacina> update(@PathVariable Long id, @RequestBody Vacina obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}