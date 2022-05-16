package com.jonathasdeveloper.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jonathasdeveloper.entities.Atendimento;
import com.jonathasdeveloper.repositories.AtendimentoRepository;
import com.jonathasdeveloper.services.exceptions.DatabaseException;
import com.jonathasdeveloper.services.exceptions.ResourceNotFoundException;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository repository;

	public List<Atendimento> findAll() {
		return repository.findAll();
	}
	
	public Atendimento findById(Long id) {
		Optional<Atendimento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Atendimento insert(Atendimento obj) {
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
	
	public Atendimento update(Long id, Atendimento obj) {
		try {
			Atendimento entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}
	
	private void updateData(Atendimento entity, Atendimento obj) {
		entity.setData(obj.getData());
		entity.setStatusAtendimento(obj.getStatus());
		entity.setTipoAtendimento(obj.getTipoAtendimento());
		entity.setValor(obj.getValor());
		entity.setPet(obj.getPet());
		entity.setVet(obj.getVet());
		
	
	}
	
}