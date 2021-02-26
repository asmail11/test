package org.capiskinserver.application.hair.dto;

import java.util.List;

public class NeedsDto extends PersistableElementDto {
	
	private String name;

	private List<BaseProductDto> baseProducts;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BaseProductDto> getBaseProducts() {
		return baseProducts;
	}

	public void setBaseProducts(List<BaseProductDto> baseProducts) {
		this.baseProducts = baseProducts;
	}
	
	

}
