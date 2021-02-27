package org.capiskinserver.application.hair.service;

import java.util.List;

import org.capiskinserver.application.hair.dto.BodyAndHairDto;
import org.springframework.stereotype.Service;

@Service
public interface BodyAndHairManagerService {
	
	BodyAndHairDto addAndHair(BodyAndHairDto bodyAndHairDto, long idCategory);
	
	BodyAndHairDto editAndHair(BodyAndHairDto bodyAndHairDto, long idBodyAndHair);
	
	BodyAndHairDto findBodyAndHair(long idBodyAndHair);
	
	void deleteBodyAndHair(long idBodyAndHair);
	
	List<BodyAndHairDto> findBodyAndHairForCategory(long idCategory);

}
