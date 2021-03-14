package org.capiskinserver.application.hair.service;

import java.util.List;

import org.capiskinserver.application.hair.dto.IngredientDto;



public interface IngredientManagerService {

	IngredientDto addProduct(IngredientDto productDto);
	
	IngredientDto editProduct(IngredientDto productDto, long idProduct);
	
	IngredientDto findProduct(long id);
	
	void deleteProduct(long id);
	
	List<IngredientDto> findProducts();
	
	boolean productNameExists(String name);
}
