package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.IngrdientDao;
import org.capiskinserver.domain.hair.modal.FaceAndCare;
import org.capiskinserver.domain.hair.modal.Ingrdient;
import org.capiskinserver.exception.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngrdientDomainServiceImpl implements IngrdientDomainService {

	@Autowired
	private IngrdientDao ingrdientDao;

	@Override
	public Ingrdient addIngrdient(Ingrdient ingrdient, FaceAndCare faceAndCare) {
		if (faceAndCare.hasIngrdient(ingrdient.getName())) {
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
	public Ingrdient editIngrdient(Ingrdient ingrdient, Ingrdient existIngrdient) {
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
