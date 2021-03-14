package org.capiskinserver.application.hair.service;

import java.util.List;

import org.capiskinserver.application.hair.dto.BodyFaceHairDto;
import org.springframework.stereotype.Service;

@Service
public interface BodyFaceHairManagerService {
	
	BodyFaceHairDto addBodyFaceHair(BodyFaceHairDto bodyAndHairDto);
	
	BodyFaceHairDto editBodyFaceHair(BodyFaceHairDto bodyAndHairDto, long idBodyAndHair);
	
	BodyFaceHairDto findBodyFaceHair(long idBodyAndHair);
	
	void deleteBodyFaceHair(long idBodyAndHair);
	
	 boolean bodyAndHairNameExists(String checkedName);
	 
	 List<BodyFaceHairDto> findBodyFaceHairs();

}
