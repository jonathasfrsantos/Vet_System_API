package com.jonathasdeveloper.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Table(name = "tb_pet")
public class Pet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false, length = 200)
	private String nome;
	
	@NotBlank
	@Column(nullable = false, length = 100)
	private String raca;
	
	@NotBlank
	@Column(nullable = false, length = 20)
	private String especie;
	
	@NotBlank
	@Column(nullable = false, length = 5)
	private String sexo;
	
	@NotBlank
	@Column(nullable = false, length = 100)
	private String cor;

	@ManyToOne
	@JoinColumn(name = "id_tutor")
	private Tutor tutor;
	
	@OneToMany(mappedBy = "id.pet")
	private Set<Vacinacao> cartao_vacina = new HashSet<>();

	public Pet(Long id, @NotBlank String nome, @NotBlank String raca, @NotBlank String especie, @NotBlank String sexo,
			@NotBlank String cor, Tutor tutor) {
		this.id = id;
		this.nome = nome;
		this.raca = raca;
		this.especie = especie;
		this.sexo = sexo;
		this.cor = cor;
		this.tutor = tutor;
	}
	
	

	/*
	 * @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL) private CartaoVacina
	 * cartaoVacina;
	 */

}
