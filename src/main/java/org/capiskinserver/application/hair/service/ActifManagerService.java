package org.capiskinserver.application.hair.service;

import org.capiskinserver.application.hair.dto.ActifDto;
import org.springframework.stereotype.Service;

@Service
public interface ActifManagerService {
	
	ActifDto addActif(ActifDto actifDto, long idCharacteristic);
	
	ActifDto editActif(ActifDto actifDto, long idActif);
	
	ActifDto findActif(long idActif);
	
	ActifDto findActifForCharacteristic(long idCharacteristic);
	
	void deleteActif(long idActif, long idCharacteristic);

}
