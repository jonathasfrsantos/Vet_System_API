package com.jonathasdeveloper.resources;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathasdeveloper.dto.VeterinarioDTO;
import com.jonathasdeveloper.entities.Veterinario;
import com.jonathasdeveloper.services.VeterinarioService;

@RestController
@RequestMapping(value = "/veterinarios")
public class VeterinarioResource {

	@Autowired
	private VeterinarioService veterinarioService;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid VeterinarioDTO veterinarioDTO) {
		Veterinario veterinario = new Veterinario();
		BeanUtils.copyProperties(veterinarioDTO, veterinario);
		return ResponseEntity.status(HttpStatus.CREATED).body(veterinarioService.save(veterinario));
	}
	
	
	@GetMapping
	public ResponseEntity<Page<Veterinario>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(veterinarioService.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
		Optional<Veterinario> veterinario = veterinarioService.findById(id);
		if (!veterinario.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veterinario não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(veterinario.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
		Optional<Veterinario> veterinario = veterinarioService.findById(id);
		if (!veterinario.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veterinario não encontrado!");
		}
		veterinarioService.delete(veterinario.get());
		return ResponseEntity.status(HttpStatus.OK).body("Veterinario deletedo com sucesso!");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id,
			@RequestBody @Valid VeterinarioDTO veterinarioDTO) {
		Optional<Veterinario> veterinarioOptional = veterinarioService.findById(id);
		if (!veterinarioOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("veterinario não encontrado");
		}
		var newVeterinarioObj = new Veterinario();
		BeanUtils.copyProperties(veterinarioDTO, newVeterinarioObj);
		newVeterinarioObj.setId(veterinarioOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(veterinarioService.save(newVeterinarioObj));
	}

}
