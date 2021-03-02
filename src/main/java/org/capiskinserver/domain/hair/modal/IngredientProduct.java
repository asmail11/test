package org.capiskinserver.domain.hair.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.capiskinserver.util.PersistableElement;

@Entity
@Table(name = "ingredientProducts")
public class IngredientProduct extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Size(min = 3, max = 50)
	@Column(unique =  true)
	private String name;
	
	private String photo;
	
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

	public IngredientProduct(String name, String photo, int millilimter, double price, BaseProduct baseProduct,
			List<FinalProduct> finalProducts) {
		super();
		this.name = name;
		this.photo = photo;
		this.millilimter = millilimter;
		this.price = price;
		this.baseProduct = baseProduct;
		this.finalProducts = finalProducts;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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
