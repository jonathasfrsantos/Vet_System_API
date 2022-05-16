package com.jonathasdeveloper.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jonathasdeveloper.entities.Veterinario;
import com.jonathasdeveloper.repositories.VeterinarioRepository;
import com.jonathasdeveloper.services.exceptions.DatabaseException;
import com.jonathasdeveloper.services.exceptions.ResourceNotFoundException;

@Service
public class VeterinarioService {

	@Autowired
	private VeterinarioRepository repository;

	public List<Veterinario> findAll() {
		return repository.findAll();
	}
	
	public Veterinario findById(Long id) {
		Optional<Veterinario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Veterinario insert(Veterinario obj) {
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
	
	public Veterinario update(Long id, Veterinario obj) {
		try {
			Veterinario entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}
	
	private void updateData(Veterinario entity, Veterinario obj) {
		entity.setNome(obj.getNome());
		entity.setCRMV(obj.getCRMV());
	
	}
	
}