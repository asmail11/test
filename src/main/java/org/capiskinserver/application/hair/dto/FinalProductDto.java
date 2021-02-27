package org.capiskinserver.application.hair.dto;

import java.util.List;

public class FinalProductDto extends PersistableElementDto {

	private List<IngredientProductDto> ingredientProducts;

	public List<IngredientProductDto> getIngredientProducts() {
		return ingredientProducts;
	}

	public void setIngredientProducts(List<IngredientProductDto> ingredientProducts) {
		this.ingredientProducts = ingredientProducts;
	}

}
