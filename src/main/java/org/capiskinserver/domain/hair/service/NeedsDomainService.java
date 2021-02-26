package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.Characteristic;
import org.capiskinserver.domain.hair.modal.Needs;
import org.springframework.stereotype.Service;

@Service
public interface NeedsDomainService {
	
	Needs addNeeds(Needs needs, Characteristic characteristic);
	
	Needs editNeeds(Needs needs, Needs existNeeds);

}
