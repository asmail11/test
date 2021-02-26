package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.Category;
import org.capiskinserver.domain.hair.modal.Characteristic;
import org.springframework.stereotype.Service;

@Service
public interface CharacteristicDomainService {
	
	Characteristic addCharacteristic(Characteristic characteristic, Category category);
	
	Characteristic editCharacteristic(Characteristic characteristic, Characteristic existCharacteristic);

}
