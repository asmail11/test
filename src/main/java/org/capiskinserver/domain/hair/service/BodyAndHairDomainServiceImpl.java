package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.BodyAndHairDao;
import org.capiskinserver.domain.hair.modal.BodyAndHair;
import org.capiskinserver.domain.hair.modal.Category;
import org.capiskinserver.exception.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BodyAndHairDomainServiceImpl implements BodyAndHairDomainService {

	@Autowired
	private BodyAndHairDao bodyAndHairDao;

	@Override
	public BodyAndHair addBodyAndHair(BodyAndHair bodyAndHair, Category category) {
		if (category.hasBodyAndHair(bodyAndHair.getName())) {
			throw new AlreadyExistsException("\n The name of bodyAndHair has be unique \n");
		}
		if (bodyAndHair != null && category != null) {
			bodyAndHair.setCreatedAt(new Date());
			category.addBodyAndHair(bodyAndHair);
			return bodyAndHairDao.save(bodyAndHair);
		}
		return null;
	}

	@Override
	public BodyAndHair editBodyAndHair(BodyAndHair bodyAndHair, BodyAndHair existBodyAndHair) {
		if (bodyAndHair != null && existBodyAndHair != null) {
			existBodyAndHair.setCreatedAt(null);
			existBodyAndHair.setUpdatedAt(new Date());
			existBodyAndHair.setName(bodyAndHair.getName());
			existBodyAndHair.setDescription(bodyAndHair.getDescription());
			return bodyAndHairDao.save(existBodyAndHair);
		}
		return null;
	}

}
