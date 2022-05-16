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

import com.jonathasdeveloper.dto.TutorDTO;
import com.jonathasdeveloper.entities.Tutor;
import com.jonathasdeveloper.repositories.TutorRepository;
import com.jonathasdeveloper.services.TutorService;

@RestController
@RequestMapping(value = "/tutores")
public class TutorResource {

	@Autowired
	private TutorService tutorService;


	@PostMapping
	public ResponseEntity<Object> saveTutor(@RequestBody @Valid TutorDTO tutorDTO) {
		Tutor tutor = new Tutor();
		BeanUtils.copyProperties(tutorDTO, tutor);
		return ResponseEntity.status(HttpStatus.CREATED).body(tutorService.save(tutor));

	}

	@GetMapping
	public ResponseEntity<Page<Tutor>> findAll(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(tutorService.findAll(pageable));

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
		Optional<Tutor> tutor = tutorService.findById(id);
		if (!tutor.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tutor not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(tutor.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
		Optional<Tutor> tutor = tutorService.findById(id);
		if (!tutor.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tutor not found");
		}
		tutorService.delete(tutor.get());
		return ResponseEntity.status(HttpStatus.OK).body("Tutor deleted successfully");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTutor(@PathVariable(value = "id") Long id,
			@RequestBody @Valid TutorDTO tutorDTO) {
		Optional<Tutor> tutorOptional = tutorService.findById(id);
		if (!tutorOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tutor not found.");
		}
		var newTutorObj = new Tutor();
		BeanUtils.copyProperties(tutorDTO, newTutorObj);
		newTutorObj.setId(tutorOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(tutorService.save(newTutorObj));
	}

}
