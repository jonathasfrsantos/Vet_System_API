package com.jonathasdeveloper.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
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

	/*
	 * @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL) private CartaoVacina
	 * cartaoVacina;
	 */

}
