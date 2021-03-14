package org.capiskinserver.application.hair.service;

import java.util.List;

import org.capiskinserver.application.hair.dto.ProductDto;



public interface ProductManagerService {

	ProductDto addProduct(ProductDto productDto);
	
	ProductDto editProduct(ProductDto productDto, long idProduct);
	
	ProductDto findProduct(long id);
	
	void deleteProduct(long id);
	
	List<ProductDto> findProducts();
	
	boolean productNameExists(String name);
}
