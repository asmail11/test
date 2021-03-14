package org.capiskinserver.domain.hair.service;


import org.capiskinserver.domain.hair.modal.Characteristic;
import org.capiskinserver.domain.hair.modal.Type;
import org.springframework.stereotype.Service;

@Service
public interface CharacteristicDomainService {
	
	Characteristic addCharacteristic(Characteristic characteristic, Type type);
	
	Characteristic editCharacteristic(Characteristic characteristic, Characteristic existCharacteristic);

}
