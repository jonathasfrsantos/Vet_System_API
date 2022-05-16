package com.jonathasdeveloper.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jonathasdeveloper.entities.Pet;
import com.jonathasdeveloper.repositories.PetRepository;
import com.jonathasdeveloper.services.exceptions.DatabaseException;
import com.jonathasdeveloper.services.exceptions.ResourceNotFoundException;

@Service
public class PetService {

	@Autowired
	private PetRepository repository;

	public List<Pet> findAll() {
		return repository.findAll();
	}
	
	public Pet findById(Long id) {
		Optional<Pet> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Pet insert(Pet obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Pet update(Long id, Pet obj) {
		try {
			Pet entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
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