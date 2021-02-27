package org.capiskinserver.application.hair.service;

import org.capiskinserver.application.hair.dto.EssentialOilDto;
import org.springframework.stereotype.Service;

@Service
public interface EssentialOilManagerService {

	EssentialOilDto addEssentialOil(EssentialOilDto essentialOilDto, long idCharar);
	
	EssentialOilDto editEssentialOil(EssentialOilDto essentialOilDto, long idEssentialOil);
	
	EssentialOilDto findEssentialOil(long idEssentialOil);
	
	EssentialOilDto findEssentialOilForCharar(long idCharar);
	
	void deleteEssentialOil(long idEssentialOil, long idCharar);
}
