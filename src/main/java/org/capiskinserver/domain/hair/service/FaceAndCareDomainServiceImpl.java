package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.FaceAndCareDao;
import org.capiskinserver.domain.hair.modal.BodyAndHair;
import org.capiskinserver.domain.hair.modal.FaceAndCare;
import org.capiskinserver.exception.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FaceAndCareDomainServiceImpl implements FaceAndCareDomainService {

	@Autowired
	private FaceAndCareDao faceAndCareDao;

	@Override
	public FaceAndCare addFaceAndCare(FaceAndCare faceAndCare, BodyAndHair bodyAndHair) {

		if (bodyAndHair.hasFaceAndCare(faceAndCare.getName())) {
			throw new AlreadyExistsException("\n The name of faceAndCare has be unique \n");
		}
		if (faceAndCare != null && bodyAndHair != null) {
			faceAndCare.setCreatedAt(new Date());
			bodyAndHair.addFaceAndCare(faceAndCare);
			return faceAndCareDao.save(faceAndCare);
		}
		return null;
	}

	@Override
	public FaceAndCare editFaceAndCare(FaceAndCare faceAndCare, FaceAndCare existFaceAndCare) {
		if (faceAndCare != null && existFaceAndCare != null) {
			existFaceAndCare.setCreatedAt(null);
			existFaceAndCare.setUpdatedAt(new Date());
			existFaceAndCare.setName(faceAndCare.getName());
			existFaceAndCare.setDescription(faceAndCare.getDescription());
			return faceAndCareDao.save(existFaceAndCare);
		}
		return null;
	}

}
