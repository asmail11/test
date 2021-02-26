package org.capiskinserver.application.hair.dto;

import java.util.List;

public class CategoryDto extends PersistableElementDto {

	private String name;

	private List<BodyAndHairDto> bodyAndHairs;

	private List<CharacteristicDto> characteristics;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BodyAndHairDto> getBodyAndHairs() {
		return bodyAndHairs;
	}

	public void setBodyAndHairs(List<BodyAndHairDto> bodyAndHairs) {
		this.bodyAndHairs = bodyAndHairs;
	}

	public List<CharacteristicDto> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(List<CharacteristicDto> characteristics) {
		this.characteristics = characteristics;
	}

}
