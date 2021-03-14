package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.IngredientDao;
import org.capiskinserver.domain.hair.modal.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredientDomainServiceImpl implements IngredientDomainService {

	@Autowired
	private IngredientDao productDao;

	@Override
	public Ingredient addProduct(Ingredient product) {
		if (product != null) {
			product.setCreatedAt(new Date());
			return productDao.save(product);
		}
		return null;
	}

	@Override
	public Ingredient editProduct(Ingredient product, Ingredient existProduct) {
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
