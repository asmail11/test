package org.capiskinserver.application.hair.service;

import java.util.List;

import org.capiskinserver.application.hair.dto.FinalProductDto;
import org.springframework.stereotype.Service;

@Service
public interface FinalProductManagerService {
	
	FinalProductDto addFinalProduct(FinalProductDto finalProductDto, List<Long> idIngredients, long idContent);
	
	void deleteFinalProduct(long idFinalProduct, long idIngredient, long idContent);

}
