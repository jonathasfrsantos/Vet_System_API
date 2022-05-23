package com.jonathasdeveloper.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jonathasdeveloper.entities.Veterinario;
import com.jonathasdeveloper.repositories.VeterinarioRepository;
import com.jonathasdeveloper.services.exceptions.ResourceNotFoundException;

@Service
public class VeterinarioService {

	@Autowired
	private VeterinarioRepository veterinarioRepository;

	@Transactional
	public Veterinario save(Veterinario obj) {
		return veterinarioRepository.save(obj);
	}

	public Page<Veterinario> findAll(Pageable pageable) {
		return veterinarioRepository.findAll(pageable);
	}

	public Optional<Veterinario> findById(Long id) {
		return veterinarioRepository.findById(id);
	}

	@Transactional
	public void delete(Veterinario veterinario) {
		veterinarioRepository.delete(veterinario);
	}

	public Veterinario update(Long id, Veterinario veterinario) {
		try {
			Veterinario entity = veterinarioRepository.getById(id);
			updateData(entity, veterinario);
			return veterinarioRepository.save(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Veterinario veterinario, Veterinario obj) {
		veterinario.setNome(obj.getNome());
		veterinario.setCRMV(obj.getCRMV());

	}

}