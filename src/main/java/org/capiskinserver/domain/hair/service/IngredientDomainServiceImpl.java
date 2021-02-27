package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.IngredientDao;
import org.capiskinserver.domain.hair.modal.FaceAndCare;
import org.capiskinserver.domain.hair.modal.Ingredient;
import org.capiskinserver.exception.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredientDomainServiceImpl implements IngredientDomainService {

	@Autowired
	private IngredientDao ingrdientDao;

	@Override
	public Ingredient addIngredient(Ingredient ingrdient, FaceAndCare faceAndCare) {
		if (faceAndCare.hasIngredient(ingrdient.getName())) {
			throw new AlreadyExistsException("\n The name of ingrdient has be unique \n");
		}
		if (ingrdient != null && faceAndCare != null) {
			ingrdient.setCreatedAt(new Date());
			faceAndCare.addIngrdient(ingrdient);
			return ingrdientDao.save(ingrdient);
		}
		return null;
	}

	@Override
	public Ingredient editIngredient(Ingredient ingrdient, Ingredient existIngrdient) {
		if (ingrdient != null && existIngrdient != null) {
			existIngrdient.setCreatedAt(null);
			existIngrdient.setUpdatedAt(new Date());
			existIngrdient.setName(ingrdient.getName());
			existIngrdient.setDescription(ingrdient.getDescription());
			return ingrdientDao.save(existIngrdient);
		}
		return null;
	}

}
