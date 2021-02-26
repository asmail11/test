package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.FinalProductDao;
import org.capiskinserver.domain.hair.modal.ContentMillimiter;
import org.capiskinserver.domain.hair.modal.FinalProduct;
import org.capiskinserver.domain.hair.modal.IngredientProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FinalProductDomainServiceImpl implements FinalProductDomainService {

	@Autowired
	private FinalProductDao finalProductDao;

	@Override
	public FinalProduct createFinalProduct(FinalProduct finalProduct, IngredientProduct ingredientProduct,
			ContentMillimiter contentMillimiter) {
		if (finalProduct != null && ingredientProduct != null && contentMillimiter != null) {
			finalProduct.setCreatedAt(new Date());
			finalProduct.setContentMillimiter(contentMillimiter);
			contentMillimiter.setFinalProduct(finalProduct);
			return finalProductDao.save(finalProduct);
		}
		return null;
	}
}
