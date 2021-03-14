package org.capiskinserver.domain.hair.service;


import org.capiskinserver.domain.hair.modal.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductDomainService {
	
	Product addProduct(Product product);
	
	Product editProduct(Product product, Product existProduct);

}
