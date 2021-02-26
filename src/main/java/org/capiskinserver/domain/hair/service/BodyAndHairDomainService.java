package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.BodyAndHair;
import org.capiskinserver.domain.hair.modal.Category;
import org.springframework.stereotype.Service;

@Service
public interface BodyAndHairDomainService {

	BodyAndHair addBodyAndHair(BodyAndHair bodyAndHair, Category category);
	
	BodyAndHair editBodyAndHair(BodyAndHair bodyAndHair, BodyAndHair existBodyAndHair);
}
