package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.CharacteristicDao;
import org.capiskinserver.domain.hair.modal.Category;
import org.capiskinserver.domain.hair.modal.Characteristic;
import org.capiskinserver.exception.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacteristicDomainServiceImpl implements CharacteristicDomainService {

	@Autowired
	private CharacteristicDao characteristicDao;

	@Override
	public Characteristic addCharacteristic(Characteristic characteristic, Category category) {
		if (category.hasCharacteristicNature(characteristic.getNature())) {
			throw new AlreadyExistsException("\n The nature of characteristic has be unique \n");
		}
		if (category.hasCharacteristicProblem(characteristic.getProblem())) {
			throw new AlreadyExistsException("\n The problem of characteristic has be unique \n");
		}
		if (category.hasCharacteristicTexture(characteristic.getTexture())) {
			throw new AlreadyExistsException("\n The texture of characteristic has be unique \n");
		}
		if (category.hasCharacteristicTreatment(characteristic.getTreatment())) {
			throw new AlreadyExistsException("\n The treatment of characteristic has be unique \n");
		}
		if (category.hasCharacteristicType(characteristic.getType())) {
			throw new AlreadyExistsException("\n The type of characteristic has be unique \n");
		}
		if (category.hasCharacteristicVisual(characteristic.getVisual())) {
			throw new AlreadyExistsException("\n The visua of characteristic has be unique \n");
		}
		if (characteristic != null && category != null) {
			characteristic.setCreatedAt(new Date());
			category.addCharacteristic(characteristic);
			return characteristicDao.save(characteristic);
		}
		return null;
	}

	@Override
	public Characteristic editCharacteristic(Characteristic characteristic, Characteristic existCharacteristic) {
		if (characteristic != null && existCharacteristic != null) {
			existCharacteristic.setCategory(null);
			existCharacteristic.setUpdatedAt(new Date());
			existCharacteristic.setNature(characteristic.getNature());
			existCharacteristic.setProblem(existCharacteristic.getProblem());
			existCharacteristic.setTexture(characteristic.getTexture());
			existCharacteristic.setTreatment(characteristic.getTreatment());
			existCharacteristic.setType(characteristic.getType());
			existCharacteristic.setVisual(characteristic.getVisual());
			return characteristicDao.save(existCharacteristic);
		}
		return null;
	}

}
