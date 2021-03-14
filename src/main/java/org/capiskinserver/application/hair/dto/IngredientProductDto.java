package org.capiskinserver.application.hair.dto;

import java.util.List;

public class IngredientProductDto extends PersistableElementDto {

	private int millilimter;

	private double price;

	private List<FinalProductDto> finalProducts;

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

	public List<FinalProductDto> getFinalProducts() {
		return finalProducts;
	}

	public void setFinalProducts(List<FinalProductDto> finalProducts) {
		this.finalProducts = finalProducts;
	}

}
