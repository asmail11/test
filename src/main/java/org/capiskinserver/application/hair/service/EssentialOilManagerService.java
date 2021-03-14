package org.capiskinserver.application.hair.service;

import java.util.List;

import org.capiskinserver.application.hair.dto.EssentialOilDto;
import org.springframework.stereotype.Service;

@Service
public interface EssentialOilManagerService {

	EssentialOilDto addEssentialOil(EssentialOilDto essentialOilDto);
	
	EssentialOilDto editEssentialOil(EssentialOilDto essentialOilDto, long idEssentialOil);
	
	EssentialOilDto findEssentialOil(long idEssentialOil);
	
	void deleteEssentialOil(long idEssentialOil);
	
	boolean essentialOilNameExists(String checkedName);
	
	List<EssentialOilDto> findEssentialOils();
}
