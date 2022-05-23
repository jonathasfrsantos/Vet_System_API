package com.jonathasdeveloper.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jonathasdeveloper.entities.Pet;
import com.jonathasdeveloper.repositories.PetRepository;
import com.jonathasdeveloper.services.exceptions.DatabaseException;
import com.jonathasdeveloper.services.exceptions.ResourceNotFoundException;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;
	
	@Transactional
	public Pet save(Pet obj) {
		return petRepository.save(obj);
	}

	public Page<Pet> findAll(Pageable pageable) {
		return petRepository.findAll(pageable);
	}
	
	public Optional<Pet>findById(Long id) {
		return petRepository.findById(id);
	}
	
	@Transactional
	public void delete(Pet pet) {
		petRepository.delete(pet);
	}
	
	
	public Pet update(Long id, Pet obj) {
		try {
			Pet entity = petRepository.getById(id);
			updateData(entity, obj);
			return petRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}
	
	private void updateData(Pet entity, Pet obj) {
		entity.setNome(obj.getNome());
		entity.setEspecie(obj.getEspecie());
		entity.setRaca(obj.getRaca());
		entity.setCor(obj.getCor());
		entity.setSexo(obj.getSexo());
		entity.setTutor(obj.getTutor());
	
	}
	
}