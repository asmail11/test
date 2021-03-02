package org.capiskinserver.domain.hair.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.capiskinserver.util.PersistableElement;

@Entity
@Table(name = "finalProducts")
public class FinalProduct extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ContentMillimiter contentMillimiter;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "final_products_ingredeiennts",
            joinColumns = @JoinColumn(name = "ingredientProduct_id"),
            inverseJoinColumns = @JoinColumn(name = "finalProduct_id"))
	private List<IngredientProduct> ingredientProducts;

	public FinalProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FinalProduct(ContentMillimiter contentMillimiter, List<IngredientProduct> ingredientProducts) {
		super();
		this.contentMillimiter = contentMillimiter;
		this.ingredientProducts = ingredientProducts;
	}

	public ContentMillimiter getContentMillimiter() {
		return contentMillimiter;
	}

	public void setContentMillimiter(ContentMillimiter contentMillimiter) {
		this.contentMillimiter = contentMillimiter;
	}

	public List<IngredientProduct> getIngredientProducts() {
		return ingredientProducts;
	}

	public void setIngredientProducts(List<IngredientProduct> ingredientProducts) {
		this.ingredientProducts = ingredientProducts;
	}
	public void addIngredientProductForProduct(IngredientProduct ingredientProduct) {
		if (getIngredientProducts()==null) {
			this.ingredientProducts = new ArrayList<>();
		}
		if (!getIngredientProducts().contains(ingredientProduct)) {
			getIngredientProducts().add(ingredientProduct);
		}
	}
	

}
