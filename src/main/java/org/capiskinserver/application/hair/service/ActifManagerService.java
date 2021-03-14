package org.capiskinserver.application.hair.service;

import java.util.List;

import org.capiskinserver.application.hair.dto.ActifDto;
import org.springframework.stereotype.Service;

@Service
public interface ActifManagerService {
	
	ActifDto addActif(ActifDto actifDto);
	
	ActifDto editActif(ActifDto actifDto, long idActif);
	
	ActifDto findActif(long idActif);
	
	void deleteActif(long idActif);
	
	Boolean actifNameExists(String checkedName);
	
	List<ActifDto> finActifs();

}
