package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.BaseProduct;
import org.capiskinserver.domain.hair.modal.IngredientProduct;
import org.springframework.stereotype.Service;

@Service
public interface IngredientProductDominService {
	
	IngredientProduct addIngredientProduct(IngredientProduct ingredientProduct, BaseProduct baseProduct);
	
	IngredientProduct beditIngredientProduct(IngredientProduct ingredientProduct, IngredientProduct existIngredientProduct);

}
