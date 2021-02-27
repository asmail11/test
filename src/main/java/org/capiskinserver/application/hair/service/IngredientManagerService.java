package org.capiskinserver.application.hair.service;

import java.util.List;

import org.capiskinserver.application.hair.dto.IngredientDto;
import org.springframework.stereotype.Service;

@Service
public interface IngredientManagerService {
	
	IngredientDto addIngrdient(IngredientDto ingrdientDto, long idFace);
	
	IngredientDto editIngrdient(IngredientDto ingrdientDto, long idIngrdient);
	
	IngredientDto findIngrdient(long idIngrdient);
	
	void deleteIngrdient(long idIngrdient);
	
	List<IngredientDto> findIngrdientsForFaceAndCare(long idFace);

}
