package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.IngredientProductDao;
import org.capiskinserver.domain.hair.modal.BaseProduct;
import org.capiskinserver.domain.hair.modal.IngredientProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredientProductDominServiceImpl implements IngredientProductDominService {

	@Autowired
	private IngredientProductDao ingredientProductDao;

	@Override
	public IngredientProduct addIngredientProduct(IngredientProduct ingredientProduct, BaseProduct baseProduct) {
		if (ingredientProduct != null && baseProduct != null) {
			ingredientProduct.setCreatedAt(new Date());
			baseProduct.setIngredientProduct(ingredientProduct);
			return ingredientProductDao.save(ingredientProduct);

		}
		return null;
	}

	@Override
	public IngredientProduct editIngredientProduct(IngredientProduct ingredientProduct,
			IngredientProduct existIngredientProduct) {
		if (ingredientProduct != null && existIngredientProduct != null) {
			existIngredientProduct.setCreatedAt(null);
			existIngredientProduct.setUpdatedAt(new Date());
			existIngredientProduct.setName(ingredientProduct.getName());
			existIngredientProduct.setPhoto(existIngredientProduct.getPhoto());
			existIngredientProduct.setMillilimter(ingredientProduct.getMillilimter());
			existIngredientProduct.setPrice(ingredientProduct.getPrice());
			return ingredientProductDao.save(existIngredientProduct);

		}
		return null;
	}

}
