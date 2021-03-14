package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.BodyFaceHair;
import org.capiskinserver.domain.hair.modal.Type;
import org.springframework.stereotype.Service;

@Service
public interface TypeDomainService {
	
	Type addType(Type type, BodyFaceHair bodyFaceHair);
	
	Type ediType(Type type, Type existType);

}
