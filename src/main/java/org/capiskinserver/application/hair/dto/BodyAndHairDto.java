package org.capiskinserver.application.hair.dto;

import java.util.List;

public class BodyAndHairDto extends PersistableElementDto {

	private String name;

	private List<FaceAndCareDto> faceAndCares;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FaceAndCareDto> getFaceAndCares() {
		return faceAndCares;
	}

	public void setFaceAndCares(List<FaceAndCareDto> faceAndCares) {
		this.faceAndCares = faceAndCares;
	}

}
