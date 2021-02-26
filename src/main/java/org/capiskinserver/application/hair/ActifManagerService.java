package org.capiskinserver.application.hair;

import org.capiskinserver.application.hair.dto.ActifDto;
import org.springframework.stereotype.Service;

@Service
public interface ActifManagerService {
	
	ActifDto addActif(ActifDto actifDto, long idCharacteristic);
	
	ActifDto editActif(ActifDto actifDto, long idActif);
	
	ActifDto finActif(long idActif);
	
	ActifDto finActifForCharacteristic(long idCharacteristic);
	
	void deleteActif(long idActif, long idCharacteristic);

}
