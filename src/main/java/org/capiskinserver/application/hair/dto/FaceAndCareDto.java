package org.capiskinserver.application.hair.dto;

import java.util.List;



public class FaceAndCareDto extends PersistableElementDto {
	
	private String name;

	private List<IngrdientDto> ingrdients;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<IngrdientDto> getIngrdients() {
		return ingrdients;
	}

	public void setIngrdients(List<IngrdientDto> ingrdients) {
		this.ingrdients = ingrdients;
	}
	
	


}
