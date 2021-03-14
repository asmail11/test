package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.EssentialOil;
import org.springframework.stereotype.Service;

@Service
public interface EssentialOilDomainService {

	EssentialOil addEssentialOil(EssentialOil essentialOil);
	
	EssentialOil editEssentialOil(EssentialOil essentialOil, EssentialOil existEssentialOil);
}
