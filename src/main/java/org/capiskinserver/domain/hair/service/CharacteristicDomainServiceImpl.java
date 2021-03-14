package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.CharacteristicDao;
import org.capiskinserver.domain.hair.modal.Characteristic;
import org.capiskinserver.domain.hair.modal.Type;
import org.capiskinserver.exception.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacteristicDomainServiceImpl implements CharacteristicDomainService {

	@Autowired
	private CharacteristicDao characteristicDao;

	@Override
	public Characteristic addCharacteristic(Characteristic characteristic, Type type) {
		
		if (type.hasCharacteristicName(characteristic.getName())) {
			throw new AlreadyExistsException("The name must be unique");
		}

		if (characteristic != null && type != null) {
			characteristic.setCreatedAt(new Date());
			type.addCharacteristic(characteristic);
			return characteristicDao.save(characteristic);
		}
		return null;
	}

	@Override
	public Characteristic editCharacteristic(Characteristic characteristic, Characteristic existCharacteristic) {
		if (characteristic != null && existCharacteristic != null) {
			existCharacteristic.setCreatedAt(null);
			existCharacteristic.setUpdatedAt(new Date());
			existCharacteristic.setName(characteristic.getName());
			existCharacteristic.setDescription(characteristic.getDescription());
			return characteristicDao.save(existCharacteristic);
		}
		return null;
	}

}
