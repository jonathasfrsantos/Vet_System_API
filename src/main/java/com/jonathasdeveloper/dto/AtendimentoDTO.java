package com.jonathasdeveloper.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.jonathasdeveloper.entities.Pet;
import com.jonathasdeveloper.entities.Veterinario;
import com.jonathasdeveloper.entities.enums.StatusAtendimento;
import com.jonathasdeveloper.entities.enums.TipoAtendimento;

public class AtendimentoDTO {
	
	private Long id;
	@NotBlank
	private LocalDateTime data;
	@NotBlank
	private Integer statusAtendimento;
	@NotBlank
	private Integer tipoAtendimento;
	@NotBlank
	private Double valor;
	@NotBlank
	private Pet pet;
	@NotBlank
	private Veterinario veterinario;
	
	public AtendimentoDTO() {

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public StatusAtendimento getStatus() {
		return StatusAtendimento.valueOf(statusAtendimento);
	}

	public void setStatusAtendimento(StatusAtendimento statusAtendimento) {
		if (statusAtendimento != null) {
			this.statusAtendimento = statusAtendimento.getCodigo();
		}
	}

	public TipoAtendimento getTipoAtendimento() {
		return TipoAtendimento.valueOf(tipoAtendimento);
	}

	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		if (tipoAtendimento != null) {
			this.tipoAtendimento = tipoAtendimento.getCodigo();
		}
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Veterinario getVet() {
		return veterinario;
	}

	public void setVet(Veterinario vet) {
		this.veterinario = vet;
	}



}
