package org.capiskinserver.application.hair.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.capiskinserver.application.hair.dto.CharacteristicDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.CategoryDao;
import org.capiskinserver.domain.hair.dao.CharacteristicDao;
import org.capiskinserver.domain.hair.modal.Category;
import org.capiskinserver.domain.hair.modal.Characteristic;
import org.capiskinserver.domain.hair.service.CharacteristicDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CharacteristicManagerServiceImpl implements CharacteristicManagerService {

	private CharacteristicDao characteristicDao;

	private CharacteristicDomainService characteristicDomainService;

	private CategoryDao categoryDao;

	private OrikaBeanMapper orikaBeanMapper;

	@Autowired
	public CharacteristicManagerServiceImpl(CharacteristicDao characteristicDao,
			CharacteristicDomainService characteristicDomainService, CategoryDao categoryDao,
			OrikaBeanMapper orikaBeanMapper) {
		super();
		this.characteristicDao = characteristicDao;
		this.characteristicDomainService = characteristicDomainService;
		this.categoryDao = categoryDao;
		this.orikaBeanMapper = orikaBeanMapper;
	}

	@Override
	public CharacteristicDto addCharacteristic(CharacteristicDto characteristicDto, long idCategory) {
		Category category = categoryDao.getOne(idCategory);
		Characteristic characteristic = orikaBeanMapper.map(characteristicDto, Characteristic.class);
		return orikaBeanMapper.convertDTO(characteristicDomainService.addCharacteristic(characteristic, category),
				CharacteristicDto.class);
	}

	@Override
	public CharacteristicDto editCharacteristic(CharacteristicDto characteristicDto, long idCharacteristic) {
		Characteristic characteristic = orikaBeanMapper.map(characteristicDto, Characteristic.class);
		Characteristic existCharacteristic = characteristicDao.getOne(idCharacteristic);
		return orikaBeanMapper.convertDTO(
				characteristicDomainService.editCharacteristic(characteristic, existCharacteristic),
				CharacteristicDto.class);
	}

	@Override
	public CharacteristicDto findCharacteristic(long idCharacteristic) {
		return orikaBeanMapper.convertDTO(characteristicDao.getOne(idCharacteristic), CharacteristicDto.class);
	}

	@Override
	public void deleteCharacteristic(long idCharacteristic) {
		Characteristic existCharacteristic = characteristicDao.getOne(idCharacteristic);
		characteristicDao.delete(existCharacteristic);
	}

	@Override
	public List<CharacteristicDto> finCharacteristicForCategory(long idCategory) {
		Category category = categoryDao.getOne(idCategory);
		List<Characteristic> characteristics = category.getCharacteristics();
		characteristics = characteristics.stream().sorted(Comparator.comparing(Characteristic::getId))
				.collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(characteristics, CharacteristicDto.class);
	}

}
