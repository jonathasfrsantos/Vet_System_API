package com.jonathasdeveloper.entities.PK;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jonathasdeveloper.entities.Pet;
import com.jonathasdeveloper.entities.Vacina;

@Embeddable
public class VacinacaoPK  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
	
	@ManyToOne
	@JoinColumn(name = "vacina_id")
	private Vacina vacina;

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pet, vacina);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VacinacaoPK other = (VacinacaoPK) obj;
		return Objects.equals(pet, other.pet) && Objects.equals(vacina, other.vacina);
	}
	
	
	
	
	
	
	

}
