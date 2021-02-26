package org.capiskinserver.domain.hair.service;


import org.capiskinserver.domain.hair.modal.ContentMillimiter;
import org.capiskinserver.domain.hair.modal.FinalProduct;
import org.capiskinserver.domain.hair.modal.IngredientProduct;
import org.springframework.stereotype.Service;

@Service
public interface FinalProductDomainService {
	
	FinalProduct createFinalProduct(FinalProduct finalProduct, IngredientProduct ingredientProduct, ContentMillimiter contentMillimiter);

}
