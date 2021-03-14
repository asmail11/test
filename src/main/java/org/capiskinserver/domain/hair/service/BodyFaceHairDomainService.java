package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.BodyFaceHair;
import org.springframework.stereotype.Service;

@Service
public interface BodyFaceHairDomainService {

	BodyFaceHair addBodyFaceHair(BodyFaceHair bodyAndHair);
	
	BodyFaceHair editBodyFaceHair(BodyFaceHair bodyAndHair, BodyFaceHair existBodyAndHair);
}
