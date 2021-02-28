package org.capiskinserver.application.hair.service;

import org.capiskinserver.application.hair.dto.VegetableOilDto;
import org.springframework.stereotype.Service;

@Service
public interface VegetableOilManagerService {
	
	VegetableOilDto addVegetableOil(VegetableOilDto vegetableOilDto, long idCharacteristic);
	
	VegetableOilDto editVegetableOil(VegetableOilDto vegetableOilDto, long idVegetableOil);
	
	VegetableOilDto findVegetableOil(long idVegetableOil);
	
	VegetableOilDto findVegetableOilForCharacteristic(long idCharacteristic);
	
	void deleteVegetableOil(long idVegetableOil, long idCharacteristic);
	

}
