package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.Actif;
import org.capiskinserver.domain.hair.modal.Characteristic;
import org.springframework.stereotype.Service;

@Service
public interface ActifDomainService {
	
	Actif addActif(Actif actif, Characteristic characteristic);
	
	Actif editActif(Actif actif, Actif existActif);

}
