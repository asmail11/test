package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.TypeDao;

import org.capiskinserver.domain.hair.modal.BodyFaceHair;
import org.capiskinserver.domain.hair.modal.Type;
import org.capiskinserver.exception.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TypeDomainServiceImpl implements TypeDomainService {

	@Autowired
	private TypeDao typeDao;

	@Override
	public Type addType(Type type, BodyFaceHair bodyFaceHair) {
		if (bodyFaceHair.hasType(type.getName())) {
			throw new AlreadyExistsException("The name must be unique");
		}
		if (type != null && bodyFaceHair != null) {
			type.setCreatedAt(new Date());
			bodyFaceHair.addType(type);
			return typeDao.save(type);
		}
		return null;
	}

	@Override
	public Type ediType(Type type, Type existType) {
		if (type != null && existType != null) {
			existType.setCreatedAt(null);
			existType.setUpdatedAt(new Date());
			existType.setName(type.getName());
			existType.setDescription(type.getDescription());
			return typeDao.save(existType);
		}
		return null;
	}

}
