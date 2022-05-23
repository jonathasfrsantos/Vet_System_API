package com.jonathasdeveloper.resources;

import java.net.URI;
import java.util.List;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jonathasdeveloper.dto.PetDTO;
import com.jonathasdeveloper.dto.TutorDTO;
import com.jonathasdeveloper.entities.Pet;
import com.jonathasdeveloper.entities.Tutor;
import com.jonathasdeveloper.repositories.PetRepository;
import com.jonathasdeveloper.services.PetService;

@RestController
@RequestMapping(value = "/pets")
public class PetResource {

	@Autowired
	private PetService petService;

	@PostMapping
	public ResponseEntity<Pet> save(@RequestBody @Valid PetDTO petDTO) {
		Pet pet = new Pet();
		BeanUtils.copyProperties(petDTO, pet);
		return ResponseEntity.status(HttpStatus.CREATED).body(petService.save(pet));
	}

	@GetMapping
	public ResponseEntity<Page<Pet>> findAll(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(petService.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
		Optional<Pet> pet = petService.findById(id);
		if (!pet.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet não encontrado!");
		}

		return ResponseEntity.status(HttpStatus.OK).body(pet.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid PetDTO petDTO) {
		Optional<Pet> petOptional = petService.findById(id);
		if (!petOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet não encontrado!");
		}
		var newPetObj = new Pet();
		BeanUtils.copyProperties(petDTO, newPetObj);
		newPetObj.setId(petOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(petService.save(newPetObj));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
		Optional<Pet> pet = petService.findById(id);
		if (!pet.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet não encontrado!");
		}
		petService.delete(pet.get());
		return ResponseEntity.status(HttpStatus.OK).body("Pet deletado com sucesso!");
	}

}
