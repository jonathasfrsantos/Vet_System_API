package com.jonathasdeveloper.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_cartao_vacina")
public class CartaoVacina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@OneToOne
	private Pet pet;

	/*
	 * @OneToMany(mappedBy = "cartao_vacina.id") private Set<Vacina> vacinas = new
	 * HashSet<>();
	 */

	public CartaoVacina() {

	}

	public CartaoVacina(Long id, Pet pet) {

		this.id = id;
		this.pet = pet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartaoVacina other = (CartaoVacina) obj;
		return Objects.equals(id, other.id) && Objects.equals(pet, other.pet);
	}

	/*
	 * public Set<Vacina> getVacinas() { return vacinas; }
	 */
	

}
