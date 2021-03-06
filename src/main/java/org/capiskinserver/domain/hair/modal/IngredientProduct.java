package org.capiskinserver.domain.hair.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.capiskinserver.util.PersistableElement;

@Entity
@Table(name = "ingredientProducts")
public class IngredientProduct extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int millilimter;
	
	private double price;
	
	@OneToOne
	private BaseProduct baseProduct;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ingredient_final_products",
            joinColumns = @JoinColumn(name = "finalProduct_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredientProduct_id"))
	private List<FinalProduct> finalProducts;
    
	public IngredientProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IngredientProduct(int millilimter, double price, BaseProduct baseProduct,
			List<FinalProduct> finalProducts) {
		super();
		this.millilimter = millilimter;
		this.price = price;
		this.baseProduct = baseProduct;
		this.finalProducts = finalProducts;
	}

	public int getMillilimter() {
		return millilimter;
	}

	public void setMillilimter(int millilimter) {
		this.millilimter = millilimter;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public BaseProduct getBaseProduct() {
		return baseProduct;
	}

	public void setBaseProduct(BaseProduct baseProduct) {
		this.baseProduct = baseProduct;
	}

	public List<FinalProduct> getFinalProducts() {
		return finalProducts;
	}

	public void setFinalProducts(List<FinalProduct> finalProducts) {
		this.finalProducts = finalProducts;
	}
	
	public void addFinalProduct(FinalProduct finalProduct) {
		if (getFinalProducts()==null) {
			this.finalProducts = new ArrayList<>();
		}
		if (!getFinalProducts().contains(finalProduct)) {
			getFinalProducts().add(finalProduct);
		}
	}

}
