package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.ProductDao;
import org.capiskinserver.domain.hair.modal.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDomainServiceImpl implements ProductDomainService {

	@Autowired
	private ProductDao productDao;

	@Override
	public Product addProduct(Product product) {
		if (product != null) {
			product.setCreatedAt(new Date());
			return productDao.save(product);
		}
		return null;
	}

	@Override
	public Product editProduct(Product product, Product existProduct) {
		if (product != null && existProduct != null) {
			existProduct.setCreatedAt(null);
			existProduct.setUpdatedAt(new Date());
			existProduct.setName(product.getName());
			existProduct.setPrice(product.getPrice());
			existProduct.setPhoto(product.getPhoto());
			existProduct.setDescription(product.getDescription());
			return productDao.save(existProduct);
		}
		return null;
	}

}
