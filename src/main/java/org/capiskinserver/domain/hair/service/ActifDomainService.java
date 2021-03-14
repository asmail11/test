package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.Actif;
import org.springframework.stereotype.Service;

@Service
public interface ActifDomainService {
	
	Actif addActif(Actif actif);
	
	Actif editActif(Actif actif, Actif existActif);

}
