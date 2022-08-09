package com.jonathasdeveloper.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jonathasdeveloper.entities.Vacinacao;
import com.jonathasdeveloper.repositories.VacinacaoRepository;
import com.jonathasdeveloper.services.exceptions.ResourceNotFoundException;

@Service
public class VacinacaoService {

	@Autowired
	private VacinacaoRepository vacinacaoRepository;



	public Page<Vacinacao> findAll(Pageable pageable) {
		return vacinacaoRepository.findAll(pageable);
	}

	public Optional<Vacinacao> findById(Long id) {
		return vacinacaoRepository.findById(id);
	}




}