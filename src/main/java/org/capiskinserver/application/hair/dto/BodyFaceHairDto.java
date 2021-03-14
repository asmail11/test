package org.capiskinserver.application.hair.dto;

import java.util.List;

public class BodyFaceHairDto extends PersistableElementDto {

	private List<TypeDto> types;

	public List<TypeDto> getTypes() {
		return types;
	}

	public void setTypes(List<TypeDto> types) {
		this.types = types;
	}
  

}
