package org.capiskinserver.application.hair.dto;

public class BaseProductDto extends PersistableElementDto {

	private double price;
	
	private IngredientProductDto ingredientProduct;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public IngredientProductDto getIngredientProduct() {
		return ingredientProduct;
	}

	public void setIngredientProduct(IngredientProductDto ingredientProduct) {
		this.ingredientProduct = ingredientProduct;
	}
	
}
