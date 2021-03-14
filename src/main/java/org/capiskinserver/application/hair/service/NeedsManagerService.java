package org.capiskinserver.application.hair.service;

import java.util.List;

import org.capiskinserver.application.hair.dto.NeedsDto;
import org.springframework.stereotype.Service;

@Service
public interface NeedsManagerService {
	
	NeedsDto addNeeds(NeedsDto needsDto, long idCharacteristic);
	
	NeedsDto editNeeds(NeedsDto needsDto, long idNeeds);
	
	NeedsDto findNeeds(long idNeeds);
	
	void deleteNeeds(long id);
	
	List<NeedsDto> fiNeedsForCharacteristic(long idCharacteristic);

	boolean needsNameExists(String checkedName);
}
