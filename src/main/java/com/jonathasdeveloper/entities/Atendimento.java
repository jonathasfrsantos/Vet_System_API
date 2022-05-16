package com.jonathasdeveloper.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jonathasdeveloper.entities.enums.StatusAtendimento;
import com.jonathasdeveloper.entities.enums.TipoAtendimento;

@Entity
@Table(name = "tb_atendimento")
public class Atendimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalDateTime data;

	private Integer statusAtendimento;
	private Integer tipoAtendimento;

	private Double valor;

	@ManyToOne
	@JoinColumn(name = "id_pet")
	private Pet pet;

	@ManyToOne
	@JoinColumn(name = "id_vet")
	private Veterinario vet;

	public Atendimento() {

	}

	public Atendimento(Long id, LocalDateTime data, StatusAtendimento statusAtendimento,
			TipoAtendimento tipoAtendimento, Double valor, Pet pet, Veterinario vet) {
		this.id = id;
		this.data = data;
		setStatusAtendimento(statusAtendimento);
		setTipoAtendimento(tipoAtendimento);
		this.valor = valor;
		this.pet = pet;
		this.vet = vet;
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
		return vet;
	}

	public void setVet(Veterinario vet) {
		this.vet = vet;
	}

}
