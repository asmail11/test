package org.capiskinserver.application.hair.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.capiskinserver.application.hair.dto.IngredientDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.IngredientDao;
import org.capiskinserver.domain.hair.modal.Ingredient;
import org.capiskinserver.domain.hair.service.IngredientDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IngredientManagerServiceImpl implements IngredientManagerService {

	private OrikaBeanMapper orikaBeanMapper;

	private IngredientDomainService productDomainService;

	private IngredientDao productDao;

	@Autowired
	public IngredientManagerServiceImpl(OrikaBeanMapper orikaBeanMapper, IngredientDomainService productDomainService,
			IngredientDao productDao) {
		super();
		this.orikaBeanMapper = orikaBeanMapper;
		this.productDomainService = productDomainService;
		this.productDao = productDao;
	}

	@Override
	public IngredientDto addProduct(IngredientDto productDto) {
		Ingredient product = orikaBeanMapper.map(productDto, Ingredient.class);
		return orikaBeanMapper.convertDTO(productDomainService.addProduct(product), IngredientDto.class);
	}

	@Override
	public IngredientDto editProduct(IngredientDto productDto, long idProduct) {
		Ingredient product = orikaBeanMapper.map(productDto, Ingredient.class);
		Ingredient existProduct = productDao.getOne(idProduct);
		return orikaBeanMapper.convertDTO(productDomainService.editProduct(product, existProduct), IngredientDto.class);
	}

	@Override
	public IngredientDto findProduct(long id) {
		return orikaBeanMapper.convertDTO(productDao.getOne(id), IngredientDto.class);
	}

	@Override
	public void deleteProduct(long id) {
		Ingredient existProduct = productDao.getOne(id);
		productDao.delete(existProduct);
	}

	@Override
	public List<IngredientDto> findProducts() {
		List<Ingredient> products = productDao.findAll();
		products = products.stream().sorted(Comparator.comparing(Ingredient::getName)).collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(products, IngredientDto.class);
	}

	@Override
	public boolean productNameExists(String name) {
		return productDao.existsByName(name);
	}

}
