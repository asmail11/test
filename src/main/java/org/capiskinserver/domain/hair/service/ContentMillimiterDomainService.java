package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.ContentMillimiter;
import org.capiskinserver.domain.hair.modal.FinalProduct;
import org.springframework.stereotype.Service;

@Service
public interface ContentMillimiterDomainService {
	
	ContentMillimiter addContentMillimiter(ContentMillimiter contentMillimiter, FinalProduct finalProduct);
	
	ContentMillimiter editContentMillimiter(ContentMillimiter contentMillimiter, ContentMillimiter existContentMillimiter);
	

}
