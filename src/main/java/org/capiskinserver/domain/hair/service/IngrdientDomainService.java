package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.FaceAndCare;
import org.capiskinserver.domain.hair.modal.Ingrdient;
import org.springframework.stereotype.Service;

@Service
public interface IngrdientDomainService {

	Ingrdient addIngrdient(Ingrdient ingrdient, FaceAndCare faceAndCare);
	
	Ingrdient editIngrdient(Ingrdient ingrdient, Ingrdient existIngrdient);
}
