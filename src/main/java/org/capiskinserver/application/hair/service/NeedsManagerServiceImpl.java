package org.capiskinserver.application.hair.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.capiskinserver.application.hair.dto.NeedsDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.CharacteristicDao;
import org.capiskinserver.domain.hair.dao.NeedsDao;
import org.capiskinserver.domain.hair.modal.Characteristic;
import org.capiskinserver.domain.hair.modal.Needs;
import org.capiskinserver.domain.hair.service.NeedsDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NeedsManagerServiceImpl implements NeedsManagerService {

	private NeedsDomainService needsDomainService;

	private NeedsDao needsDao;

	private CharacteristicDao characteristicDao;

	private OrikaBeanMapper orikaBeanMapper;

	@Autowired
	public NeedsManagerServiceImpl(NeedsDomainService needsDomainService, NeedsDao needsDao,
			CharacteristicDao characteristicDao, OrikaBeanMapper orikaBeanMapper) {
		super();
		this.needsDomainService = needsDomainService;
		this.needsDao = needsDao;
		this.characteristicDao = characteristicDao;
		this.orikaBeanMapper = orikaBeanMapper;
	}

	@Override
	public NeedsDto addNeeds(NeedsDto needsDto, long idCharacteristic) {
		Needs needs = orikaBeanMapper.map(needsDto, Needs.class);
		Characteristic characteristic = characteristicDao.getOne(idCharacteristic);
		return orikaBeanMapper.convertDTO(needsDomainService.addNeeds(needs, characteristic), NeedsDto.class);
	}

	@Override
	public NeedsDto editNeeds(NeedsDto needsDto, long idNeeds) {
		Needs needs = orikaBeanMapper.map(needsDto, Needs.class);
		Needs existNeeds = needsDao.getOne(idNeeds);
		return orikaBeanMapper.convertDTO(needsDomainService.editNeeds(needs, existNeeds), NeedsDto.class);
	}

	@Override
	public NeedsDto findNeeds(long idNeeds) {
		return orikaBeanMapper.convertDTO(needsDao.getOne(idNeeds), NeedsDto.class);
	}

	@Override
	public void deleteNeeds(long idNeeds) {
		Needs existNeeds = needsDao.getOne(idNeeds);
		needsDao.delete(existNeeds);
	}

	@Override
	public List<NeedsDto> fiNeedsForCharacteristic(long idCharacteristic) {
		Characteristic characteristic = characteristicDao.getOne(idCharacteristic);
		List<Needs> needs = characteristic.getNeeds();
		needs = needs.stream().sorted(Comparator.comparing(Needs::getName)).collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(needs, NeedsDto.class);
	}

}
