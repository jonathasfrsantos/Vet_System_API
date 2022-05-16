package com.jonathasdeveloper.entities.PK;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jonathasdeveloper.entities.CartaoVacina;
import com.jonathasdeveloper.entities.Pet;
import com.jonathasdeveloper.entities.Vacina;

public class Vacina_CartaoVacinaPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_vacina")
	private Vacina vacina;
	
	@ManyToOne
	@JoinColumn(name = "id_cartao_vacina")
	private CartaoVacina cartaoVacina;

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public CartaoVacina getCartaoVacina() {
		return cartaoVacina;
	}

	public void setCartaoVacina(CartaoVacina cartaoVacina) {
		this.cartaoVacina = cartaoVacina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartaoVacina, vacina);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacina_CartaoVacinaPK other = (Vacina_CartaoVacinaPK) obj;
		return Objects.equals(cartaoVacina, other.cartaoVacina) && Objects.equals(vacina, other.vacina);
	}

}