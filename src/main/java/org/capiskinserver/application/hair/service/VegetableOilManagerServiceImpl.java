package org.capiskinserver.application.hair.service;

import org.capiskinserver.application.hair.dto.VegetableOilDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.CharacteristicDao;
import org.capiskinserver.domain.hair.dao.VegetableOilDao;
import org.capiskinserver.domain.hair.modal.Characteristic;
import org.capiskinserver.domain.hair.modal.VegetableOil;
import org.capiskinserver.domain.hair.service.VegetableOilDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class VegetableOilManagerServiceImpl implements VegetableOilManagerService {

	private VegetableOilDao vegetableOilDao;

	private VegetableOilDomainService vegetableOilDomainService;

	private CharacteristicDao characteristicDao;

	private OrikaBeanMapper orikaBeanMapper;

	@Autowired
	public VegetableOilManagerServiceImpl(VegetableOilDao vegetableOilDao,
			VegetableOilDomainService vegetableOilDomainService, CharacteristicDao characteristicDao,
			OrikaBeanMapper orikaBeanMapper) {
		super();
		this.vegetableOilDao = vegetableOilDao;
		this.vegetableOilDomainService = vegetableOilDomainService;
		this.characteristicDao = characteristicDao;
		this.orikaBeanMapper = orikaBeanMapper;
	}

	@Override
	public VegetableOilDto addVegetableOil(VegetableOilDto vegetableOilDto, long idCharacteristic) {
		VegetableOil vegetableOil = orikaBeanMapper.map(vegetableOilDto, VegetableOil.class);
		Characteristic characteristic = characteristicDao.getOne(idCharacteristic);
		return orikaBeanMapper.convertDTO(vegetableOilDomainService.addVegetableOil(vegetableOil, characteristic),
				VegetableOilDto.class);
	}

	@Override
	public VegetableOilDto editVegetableOil(VegetableOilDto vegetableOilDto, long idVegetableOil) {
		VegetableOil vegetableOil = orikaBeanMapper.map(vegetableOilDto, VegetableOil.class);
		VegetableOil existVegetableOil = vegetableOilDao.getOne(idVegetableOil);
		return orikaBeanMapper.convertDTO(vegetableOilDomainService.editVegetableOil(vegetableOil, existVegetableOil),
				VegetableOilDto.class);
	}

	@Override
	public VegetableOilDto findVegetableOil(long idVegetableOil) {
		VegetableOil existVegetableOil = vegetableOilDao.getOne(idVegetableOil);
		return orikaBeanMapper.convertDTO(existVegetableOil, VegetableOilDto.class);
	}

	@Override
	public VegetableOilDto findVegetableOilForCharacteristic(long idCharacteristic) {
		Characteristic characteristic = characteristicDao.getOne(idCharacteristic);
		return orikaBeanMapper.convertDTO(characteristic.getVegetableOil(), VegetableOilDto.class);
	}

	@Override
	public void deleteVegetableOil(long idVegetableOil, long idCharacteristic) {
		VegetableOil existVegetableOil = vegetableOilDao.getOne(idVegetableOil);
		Characteristic characteristic = characteristicDao.getOne(idCharacteristic);
		existVegetableOil.setCharacteristic(null);
		characteristic.setVegetableOil(null);
		vegetableOilDao.delete(existVegetableOil);
	}

}
