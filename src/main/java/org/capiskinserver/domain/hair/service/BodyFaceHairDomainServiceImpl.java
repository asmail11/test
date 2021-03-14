package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.BodyFaceHairDao;
import org.capiskinserver.domain.hair.modal.BodyFaceHair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BodyFaceHairDomainServiceImpl implements BodyFaceHairDomainService {

	@Autowired
	private BodyFaceHairDao bodyAndHairDao;

	@Override
	public BodyFaceHair addBodyFaceHair(BodyFaceHair bodyAndHair) {

		if (bodyAndHair != null) {
			bodyAndHair.setCreatedAt(new Date());
			return bodyAndHairDao.save(bodyAndHair);
		}
		return null;
	}

	@Override
	public BodyFaceHair editBodyFaceHair(BodyFaceHair bodyAndHair, BodyFaceHair existBodyAndHair) {
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
