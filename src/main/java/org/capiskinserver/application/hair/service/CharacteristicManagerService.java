package org.capiskinserver.application.hair.service;

import java.util.List;

import org.capiskinserver.application.hair.dto.ActifDto;
import org.capiskinserver.application.hair.dto.CharacteristicDto;
import org.capiskinserver.application.hair.dto.EssentialOilDto;
import org.capiskinserver.application.hair.dto.IngredientDto;
import org.springframework.stereotype.Service;

@Service
public interface CharacteristicManagerService {
	
    CharacteristicDto addCharacteristic(CharacteristicDto characteristicDto, long idType);
    
    CharacteristicDto editCharacteristic(CharacteristicDto characteristicDto, long idCharacteristic);
    
    CharacteristicDto findCharacteristic(long idCharacteristic);
    
    void deleteCharacteristic(long idCharacteristic);
    
    List<CharacteristicDto> finCharacteristicForCategory(long idType);
    
    boolean characteristicNameExists(String name);
    
	void addActifToCharacteristic(long idCharacteristic, long idActif);
	
	void addEssentialToCharacteristic(long idCharacteristic, long idEssential);
	
	void addProductToCharacteristic(long idCharacteristic, long idProduct);
	
	List<ActifDto> findActifsForCharacteristic(long idCharacteristic);
	
	List<EssentialOilDto> findEssentialOilsForCharacteristic(long idCharacteristic);
	
	List<IngredientDto> findProductsForCharacteristic(long idCharacteristic);
	
	void removeActifFromCharacteristic(long idCharacteristic, long idActif);
	
	void removeEssentialFromCharacteristic(long idCharacteristic, long idEssential);
	
	void removeProductFromCharacteristic(long idCharacteristic, long idProduct);
	
}
