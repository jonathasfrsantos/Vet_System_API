package com.jonathasdeveloper.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jonathasdeveloper.entities.Tutor;
import com.jonathasdeveloper.repositories.TutorRepository;
import com.jonathasdeveloper.services.exceptions.ResourceNotFoundException;

@Service
public class TutorService {

	@Autowired
	private TutorRepository tutorRepository;

	@Transactional
	public Tutor save(Tutor tutor) {
		return tutorRepository.save(tutor);
	}

	public Page<Tutor> findAll(Pageable pageable) {
		return tutorRepository.findAll(pageable);
	}

	public Optional<Tutor> findById(Long id) {
		return tutorRepository.findById(id);
	}

	@Transactional
	public void delete(Tutor tutor) {
		tutorRepository.delete(tutor);

	}

	public Tutor update(Long id, Tutor tutor) {
		try {
			Tutor entity = tutorRepository.getOne(id);
			updateData(entity, tutor);
			return tutorRepository.save(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Tutor tutor, Tutor obj) {
		tutor.setCpf(obj.getCpf());
		tutor.setNome(obj.getNome());
	}

}