package org.capiskinserver.domain.hair.service;


import org.capiskinserver.domain.hair.modal.Ingredient;
import org.springframework.stereotype.Service;

@Service
public interface IngredientDomainService {
	
	Ingredient addProduct(Ingredient product);
	
	Ingredient editProduct(Ingredient product, Ingredient existProduct);

}
