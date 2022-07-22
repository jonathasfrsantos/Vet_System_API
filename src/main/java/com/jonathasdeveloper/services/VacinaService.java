package com.jonathasdeveloper.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jonathasdeveloper.entities.Vacina;
import com.jonathasdeveloper.repositories.VacinaRepository;
import com.jonathasdeveloper.services.exceptions.DatabaseException;
import com.jonathasdeveloper.services.exceptions.ResourceNotFoundException;

@Service
public class VacinaService {

	@Autowired
	private VacinaRepository repository;

	public List<Vacina> findAll() {
		return repository.findAll();
	}
	
	public Vacina findById(Long id) {
		Optional<Vacina> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Vacina insert(Vacina obj) {
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
	
	public Vacina update(Long id, Vacina obj) {
		try {
			Vacina entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}
	
	private void updateData(Vacina entity, Vacina obj) {
		entity.setNome(obj.getNome());
		entity.setValorVenda(obj.getValorVenda());
	
	}
	
}