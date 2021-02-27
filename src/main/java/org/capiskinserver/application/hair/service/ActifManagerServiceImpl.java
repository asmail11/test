package org.capiskinserver.application.hair.service;

import org.capiskinserver.application.hair.dto.ActifDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.ActifDao;
import org.capiskinserver.domain.hair.dao.CharacteristicDao;
import org.capiskinserver.domain.hair.modal.Actif;
import org.capiskinserver.domain.hair.modal.Characteristic;
import org.capiskinserver.domain.hair.service.ActifDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ActifManagerServiceImpl implements ActifManagerService {

	private final OrikaBeanMapper orikaBeanMapper;

	private final ActifDomainService actifDomainService;

	private final CharacteristicDao characteristicDao;

	private final ActifDao actifDao;

	@Autowired
	public ActifManagerServiceImpl(OrikaBeanMapper orikaBeanMapper, ActifDomainService actifDomainService,
			CharacteristicDao characteristicDao, ActifDao actifDao) {
		super();
		this.orikaBeanMapper = orikaBeanMapper;
		this.actifDomainService = actifDomainService;
		this.characteristicDao = characteristicDao;
		this.actifDao = actifDao;
	}

	@Override
	public ActifDto addActif(ActifDto actifDto, long idCharacteristic) {
		Actif actif = orikaBeanMapper.map(actifDto, Actif.class);
		Characteristic characteristic = characteristicDao.getOne(idCharacteristic);
		return orikaBeanMapper.convertDTO(actifDomainService.addActif(actif, characteristic), ActifDto.class);
	}

	@Override
	public ActifDto editActif(ActifDto actifDto, long idActif) {
		Actif actif = orikaBeanMapper.map(actifDto, Actif.class);
		Actif existActif = actifDao.getOne(idActif);
		return orikaBeanMapper.convertDTO(actifDomainService.editActif(actif, existActif), ActifDto.class);
	}

	@Override
	public ActifDto findActif(long idActif) {
		return orikaBeanMapper.convertDTO(actifDao.getOne(idActif), ActifDto.class);
	}

	@Override
	public ActifDto findActifForCharacteristic(long idCharacteristic) {
		Characteristic characteristic = characteristicDao.getOne(idCharacteristic);
		return orikaBeanMapper.convertDTO(characteristic.getActif(), ActifDto.class);
	}

	@Override
	public void deleteActif(long idActif, long idCharacteristic) {
		Characteristic characteristic = characteristicDao.getOne(idCharacteristic);
		Actif existActif = actifDao.getOne(idActif);
		characteristic.setActif(null);
		existActif.setCharacteristic(null);
		actifDao.delete(existActif);
	}

}
