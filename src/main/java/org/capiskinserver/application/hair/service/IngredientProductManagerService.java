package org.capiskinserver.application.hair.service;

import org.capiskinserver.application.hair.dto.IngredientProductDto;
import org.springframework.stereotype.Service;

@Service
public interface IngredientProductManagerService {
	
	IngredientProductDto addIngredientProduct(IngredientProductDto ingredientProductDto, long idBase);
	
	IngredientProductDto editIngredientProduct(IngredientProductDto ingredientProductDto, long idIngredientProduct);
	
	IngredientProductDto findIngredientProduct(long idIngredientProduct);
	
	void deleteIngredientProduct(long idIngredientProduct, long idBase);
	
	IngredientProductDto findIngredientProductForBaseProduct(long idBase);

}
