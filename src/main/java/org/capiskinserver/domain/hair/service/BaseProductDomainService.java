package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.BaseProduct;
import org.capiskinserver.domain.hair.modal.Needs;
import org.springframework.stereotype.Service;

@Service
public interface BaseProductDomainService {
	
	BaseProduct addBaseProduct(BaseProduct baseProduct, Needs needs);
	
	BaseProduct editBaseProduct(BaseProduct baseProduct, BaseProduct existBaseProduct);

}
