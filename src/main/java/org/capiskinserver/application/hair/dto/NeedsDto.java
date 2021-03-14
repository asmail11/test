package org.capiskinserver.application.hair.dto;

import java.util.List;

public class NeedsDto extends PersistableElementDto {

	private List<BaseProductDto> baseProducts;

	public List<BaseProductDto> getBaseProducts() {
		return baseProducts;
	}

	public void setBaseProducts(List<BaseProductDto> baseProducts) {
		this.baseProducts = baseProducts;
	}
	
	

}
