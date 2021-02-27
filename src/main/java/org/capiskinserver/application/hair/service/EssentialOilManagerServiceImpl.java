package org.capiskinserver.application.hair.service;

import org.capiskinserver.application.hair.dto.EssentialOilDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.CharacteristicDao;
import org.capiskinserver.domain.hair.dao.EssentialOilDao;
import org.capiskinserver.domain.hair.modal.Characteristic;
import org.capiskinserver.domain.hair.modal.EssentialOil;
import org.capiskinserver.domain.hair.service.EssentialOilDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class EssentialOilManagerServiceImpl implements EssentialOilManagerService {

	private EssentialOilDao essentialOilDao;

	private EssentialOilDomainService essentialOilDomainService;

	private CharacteristicDao characteristicDao;

	private OrikaBeanMapper orikaBeanMapper;

	@Autowired
	public EssentialOilManagerServiceImpl(EssentialOilDao essentialOilDao,
			EssentialOilDomainService essentialOilDomainService, CharacteristicDao characteristicDao,
			OrikaBeanMapper orikaBeanMapper) {
		super();
		this.essentialOilDao = essentialOilDao;
		this.essentialOilDomainService = essentialOilDomainService;
		this.characteristicDao = characteristicDao;
		this.orikaBeanMapper = orikaBeanMapper;
	}

	@Override
	public EssentialOilDto addEssentialOil(EssentialOilDto essentialOilDto, long idCharar) {
		EssentialOil essentialOil = orikaBeanMapper.map(essentialOilDto, EssentialOil.class);
		Characteristic characteristic = characteristicDao.getOne(idCharar);
		return orikaBeanMapper.convertDTO(essentialOilDomainService.addEssentialOil(essentialOil, characteristic),
				EssentialOilDto.class);
	}

	@Override
	public EssentialOilDto editEssentialOil(EssentialOilDto essentialOilDto, long idEssentialOil) {
		EssentialOil essentialOil = orikaBeanMapper.map(essentialOilDto, EssentialOil.class);
		EssentialOil existEssentialOil = essentialOilDao.getOne(idEssentialOil);
		return orikaBeanMapper.convertDTO(essentialOilDomainService.editEssentialOil(essentialOil, existEssentialOil),
				EssentialOilDto.class);
	}

	@Override
	public EssentialOilDto findEssentialOil(long idEssentialOil) {
		return orikaBeanMapper.convertDTO(essentialOilDao.getOne(idEssentialOil), EssentialOilDto.class);
	}

	@Override
	public EssentialOilDto findEssentialOilForCharar(long idCharar) {
		Characteristic characteristic = characteristicDao.getOne(idCharar);
		return orikaBeanMapper.convertDTO(characteristic.getEssentialOil(), EssentialOilDto.class);
	}

	@Override
	public void deleteEssentialOil(long idEssentialOil, long idCharar) {
		Characteristic characteristic = characteristicDao.getOne(idCharar);
		EssentialOil existEssentialOil = essentialOilDao.getOne(idEssentialOil);
		characteristic.setEssentialOil(null);
		existEssentialOil.setCharacteristic(null);
		essentialOilDao.delete(existEssentialOil);
	}

}
