package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.FaceAndCare;
import org.capiskinserver.domain.hair.modal.Ingredient;
import org.springframework.stereotype.Service;

@Service
public interface IngredientDomainService {

	Ingredient addIngredient(Ingredient ingrdient, FaceAndCare faceAndCare);
	
	Ingredient editIngredient(Ingredient ingrdient, Ingredient existIngrdient);
}
