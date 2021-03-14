package org.capiskinserver.application.hair.dto;

import java.util.List;

public class TypeDto extends PersistableElementDto {
	
	private List<CharacteristicDto> characteristics;

	public List<CharacteristicDto> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(List<CharacteristicDto> characteristics) {
		this.characteristics = characteristics;
	}   
}
