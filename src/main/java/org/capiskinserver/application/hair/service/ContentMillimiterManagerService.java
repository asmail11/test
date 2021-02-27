package org.capiskinserver.application.hair.service;

import org.capiskinserver.application.hair.dto.ContentMillimiterDto;
import org.springframework.stereotype.Service;

@Service
public interface ContentMillimiterManagerService {
	
	ContentMillimiterDto addContentMillimiter(ContentMillimiterDto contentMillimiterDto, long idFinalProduct);
	
	ContentMillimiterDto editContentMillimiter(ContentMillimiterDto contentMillimiterDto, long idContentMillimiter);
	
	ContentMillimiterDto findContentMillimiter(long idContentMillimiter);
	
	void deleteContentMillimiter(long idContentMillimiter, long idFinalProduct);
	
	ContentMillimiterDto findContentMillimiterForProduct(long idFinalProduct);

}
