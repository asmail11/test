package org.capiskinserver.application.hair.service;

import java.util.List;

import org.capiskinserver.application.hair.dto.FaceAndCareDto;
import org.springframework.stereotype.Service;

@Service
public interface FaceAndCareManagerService {
	
	FaceAndCareDto addFaceAndCare(FaceAndCareDto faceAndCareDto, long idBody);
	
	FaceAndCareDto editFaceAndCare(FaceAndCareDto faceAndCareDto, long idFaceAndCare);
	
	FaceAndCareDto findFaceAndCare(long idFaceAndCare);
	
	void deleteFaceAndCare(long idFaceAndCare);
	
	List<FaceAndCareDto> findFaceAndCareForBodyAndHair(long idBody);

}
