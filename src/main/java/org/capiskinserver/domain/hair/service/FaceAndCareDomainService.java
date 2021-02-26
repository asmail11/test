package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.BodyAndHair;
import org.capiskinserver.domain.hair.modal.FaceAndCare;
import org.springframework.stereotype.Service;

@Service
public interface FaceAndCareDomainService {
	
	FaceAndCare addFaceAndCare(FaceAndCare faceAndCare, BodyAndHair bodyAndHair);
	
	FaceAndCare editFaceAndCare(FaceAndCare faceAndCare, FaceAndCare existFaceAndCare);

}
