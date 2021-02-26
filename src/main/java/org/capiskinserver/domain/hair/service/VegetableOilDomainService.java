package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.Characteristic;
import org.capiskinserver.domain.hair.modal.VegetableOil;
import org.springframework.stereotype.Service;

@Service
public interface VegetableOilDomainService {

	VegetableOil addVegetableOil(VegetableOil vegetableOil, Characteristic characteristic);
	
	VegetableOil editVegetableOil(VegetableOil vegetableOil, VegetableOil existVegetableOil);
}
