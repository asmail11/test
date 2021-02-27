package org.capiskinserver.application.hair.service;

import java.util.List;

import org.capiskinserver.application.hair.dto.CharacteristicDto;
import org.springframework.stereotype.Service;

@Service
public interface CharacteristicManagerService {
	
    CharacteristicDto addCharacteristic(CharacteristicDto characteristicDto, long idCategory);
    
    CharacteristicDto editCharacteristic(CharacteristicDto characteristicDto, long idCharacteristic);
    
    CharacteristicDto findCharacteristic(long idCharacteristic);
    
    void deleteCharacteristic(long idCharacteristic);
    
    List<CharacteristicDto> finCharacteristicForCategory(long idCategory);

}
