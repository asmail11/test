package org.capiskinserver.application.hair.dto;

import java.util.List;

public class CharacteristicDto extends PersistableElementDto {
	
	private List<NeedsDto> needs;
	

	private List<EssentialOilDto> essentialOils;

	private List<ActifDto> actifs;

	private List<IngredientDto> products;

	private List<CharacteristicDto> characteristics;

	public List<NeedsDto> getNeeds() {
		return needs;
	}


	public void setNeeds(List<NeedsDto> needs) {
		this.needs = needs;
	}
	
	public List<EssentialOilDto> getEssentialOils() {
		return essentialOils;
	}

	public void setEssentialOils(List<EssentialOilDto> essentialOils) {
		this.essentialOils = essentialOils;
	}

	public List<ActifDto> getActifs() {
		return actifs;
	}

	public void setActifs(List<ActifDto> actifs) {
		this.actifs = actifs;
	}

	public List<IngredientDto> getProducts() {
		return products;
	}

	public void setProducts(List<IngredientDto> products) {
		this.products = products;
	}

	public List<CharacteristicDto> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(List<CharacteristicDto> characteristics) {
		this.characteristics = characteristics;
	}
	

}
