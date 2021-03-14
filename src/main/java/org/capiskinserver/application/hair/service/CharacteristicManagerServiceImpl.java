package org.capiskinserver.application.hair.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.capiskinserver.application.hair.dto.ActifDto;
import org.capiskinserver.application.hair.dto.CharacteristicDto;
import org.capiskinserver.application.hair.dto.EssentialOilDto;
import org.capiskinserver.application.hair.dto.IngredientDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.ActifDao;
import org.capiskinserver.domain.hair.dao.CharacteristicDao;
import org.capiskinserver.domain.hair.dao.EssentialOilDao;
import org.capiskinserver.domain.hair.dao.IngredientDao;
import org.capiskinserver.domain.hair.dao.TypeDao;
import org.capiskinserver.domain.hair.modal.Actif;
import org.capiskinserver.domain.hair.modal.Characteristic;
import org.capiskinserver.domain.hair.modal.EssentialOil;
import org.capiskinserver.domain.hair.modal.Ingredient;
import org.capiskinserver.domain.hair.modal.Type;
import org.capiskinserver.domain.hair.service.CharacteristicDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CharacteristicManagerServiceImpl implements CharacteristicManagerService {

	private CharacteristicDao characteristicDao;

	private CharacteristicDomainService characteristicDomainService;

	private TypeDao typeDao;

	private OrikaBeanMapper orikaBeanMapper;

	private ActifDao actifDao;

	private EssentialOilDao essentialOilDao;

	private IngredientDao productDao;

	@Autowired
	public CharacteristicManagerServiceImpl(CharacteristicDao characteristicDao,
			CharacteristicDomainService characteristicDomainService, TypeDao typeDao, OrikaBeanMapper orikaBeanMapper,
			ActifDao actifDao, EssentialOilDao essentialOilDao, IngredientDao productDao) {
		super();
		this.characteristicDao = characteristicDao;
		this.characteristicDomainService = characteristicDomainService;
		this.typeDao = typeDao;
		this.orikaBeanMapper = orikaBeanMapper;
		this.actifDao = actifDao;
		this.essentialOilDao = essentialOilDao;
		this.productDao = productDao;
	}

	@Override
	public CharacteristicDto addCharacteristic(CharacteristicDto characteristicDto, long idType) {
		Type type = typeDao.getOne(idType);
		Characteristic characteristic = orikaBeanMapper.map(characteristicDto, Characteristic.class);
		return orikaBeanMapper.convertDTO(characteristicDomainService.addCharacteristic(characteristic, type),
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
	public List<CharacteristicDto> finCharacteristicForCategory(long idType) {
		Type type = typeDao.getOne(idType);
		List<Characteristic> characteristics = type.getCharacteristics();
		characteristics = characteristics.stream().sorted(Comparator.comparing(Characteristic::getId))
				.collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(characteristics, CharacteristicDto.class);
	}

	@Override
	public boolean characteristicNameExists(String name) {
		return characteristicDao.existsByName(name);
	}


	@Override
	public void addActifToCharacteristic(long idCharacteristic, long idActif) {
		Characteristic existCharacteristic = characteristicDao.getOne(idCharacteristic);
		Actif actif = actifDao.getOne(idActif);
		existCharacteristic.addActifForCharacteristic(actif);
	}

	@Override
	public void addEssentialToCharacteristic(long idCharacteristic, long idEssential) {
		Characteristic existCharacteristic = characteristicDao.getOne(idCharacteristic);
		EssentialOil essentialOil = essentialOilDao.getOne(idEssential);
		existCharacteristic.addEssentialOilForCharacteristic(essentialOil);
	}

	@Override
	public void addProductToCharacteristic(long idCharacteristic, long idProduct) {
		Characteristic existCharacteristic = characteristicDao.getOne(idCharacteristic);
		Ingredient product = productDao.getOne(idProduct);
		existCharacteristic.addProductForCharacteristic(product);
	}

	@Override
	public List<ActifDto> findActifsForCharacteristic(long idCharacteristic) {
		Characteristic existCharacteristic = characteristicDao.getOne(idCharacteristic);
		List<Actif> actifs = existCharacteristic.getActifs();
		actifs = actifs.stream().sorted(Comparator.comparing(Actif::getName)).collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(actifs, ActifDto.class);
	}

	@Override
	public List<EssentialOilDto> findEssentialOilsForCharacteristic(long idCharacteristic) {
		Characteristic existCharacteristic = characteristicDao.getOne(idCharacteristic);
		List<EssentialOil> essentialOils = existCharacteristic.getEssentialOils();
		essentialOils = essentialOils.stream().sorted(Comparator.comparing(EssentialOil::getName))
				.collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(essentialOils, EssentialOilDto.class);
	}

	@Override
	public List<IngredientDto> findProductsForCharacteristic(long idCharacteristic) {
		Characteristic existCharacteristic = characteristicDao.getOne(idCharacteristic);
		List<Ingredient> products = existCharacteristic.getProducts();
		products = products.stream().sorted(Comparator.comparing(Ingredient::getName)).collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(products, IngredientDto.class);
	}

	@Override
	public void removeActifFromCharacteristic(long idCharacteristic, long idActif) {
		Characteristic existCharacteristic = characteristicDao.getOne(idCharacteristic);
		Actif actif = actifDao.getOne(idActif);
	    existCharacteristic.getActifs().remove(actif);
	}

	@Override
	public void removeEssentialFromCharacteristic(long idCharacteristic, long idEssential) {
		Characteristic existCharacteristic = characteristicDao.getOne(idCharacteristic);
		EssentialOil essentialOil = essentialOilDao.getOne(idEssential);
		existCharacteristic.getEssentialOils().remove(essentialOil);

	}

	@Override
	public void removeProductFromCharacteristic(long idCharacteristic, long idProduct) {
		Characteristic existCharacteristic = characteristicDao.getOne(idCharacteristic);
		Ingredient product = productDao.getOne(idProduct);
		existCharacteristic.getProducts().remove(product);
	}

}
