package org.capiskinserver.domain.hair.modal;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.capiskinserver.util.PersistableElement;

@Entity
@Table(name = "essentialOils")
public class EssentialOil extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double price;

	public EssentialOil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EssentialOil(double price) {
		super();
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

 
}
