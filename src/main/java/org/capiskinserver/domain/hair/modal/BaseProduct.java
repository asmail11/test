package org.capiskinserver.domain.hair.modal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.capiskinserver.config.PersistableElement;

@Entity
@Table(name = "baseProducts")
public class BaseProduct extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(min = 3, max = 50)
	@Column(unique = true)
	private String name;

	private double price;

	@OneToOne(cascade = CascadeType.ALL)
	private IngredientProduct ingredientProduct;

	@ManyToOne
	private Needs need;

	public BaseProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseProduct(String name, double price, IngredientProduct ingredientProduct, Needs need) {
		super();
		this.name = name;
		this.price = price;
		this.ingredientProduct = ingredientProduct;
		this.need = need;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Needs getNeed() {
		return need;
	}

	public void setNeed(Needs need) {
		this.need = need;
	}

	public IngredientProduct getIngredientProduct() {
		return ingredientProduct;
	}

	public void setIngredientProduct(IngredientProduct ingredientProduct) {
		this.ingredientProduct = ingredientProduct;
	}

}
