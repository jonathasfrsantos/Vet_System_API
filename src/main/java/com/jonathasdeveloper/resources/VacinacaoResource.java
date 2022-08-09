package com.jonathasdeveloper.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathasdeveloper.entities.Vacinacao;
import com.jonathasdeveloper.services.VacinacaoService;

@RestController
@RequestMapping(value = "/vacinacoes")
public class VacinacaoResource {

	@Autowired
	private VacinacaoService vacinacaoService;

	@GetMapping
	public ResponseEntity<Page<Vacinacao>> findAll(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(vacinacaoService.findAll(pageable));

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
		Optional<Vacinacao> vacinacao = vacinacaoService.findById(id);
		if (!vacinacao.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vacinacao não encontrado!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(vacinacao.get());
	}



}
