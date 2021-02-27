package org.capiskinserver.domain.hair.service;


import org.capiskinserver.domain.hair.modal.ContentMillimiter;
import org.capiskinserver.domain.hair.modal.FinalProduct;
import org.springframework.stereotype.Service;

@Service
public interface FinalProductDomainService {
	
	FinalProduct addFinalProduct(FinalProduct finalProduct, ContentMillimiter contentMillimiter);

}
