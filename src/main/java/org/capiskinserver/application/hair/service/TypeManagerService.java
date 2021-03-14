package org.capiskinserver.application.hair.service;

import org.capiskinserver.application.hair.dto.TypeDto;
import org.springframework.stereotype.Service;

@Service
public interface TypeManagerService {
	
	TypeDto addType(TypeDto typeDto, long idBody);
	
	TypeDto editType(TypeDto typeDto, long idType);
	
	TypeDto findType(long idType);
	
	void deleteType(long id);
	 
    boolean typeNameExists(String checkedName);

}
