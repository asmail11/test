package org.capiskinserver.application.hair.service;

import org.capiskinserver.application.hair.dto.IngredientProductDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.BaseProductDao;
import org.capiskinserver.domain.hair.dao.IngredientProductDao;
import org.capiskinserver.domain.hair.modal.BaseProduct;
import org.capiskinserver.domain.hair.modal.IngredientProduct;
import org.capiskinserver.domain.hair.service.IngredientProductDominService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IngredientProductManagerServiceImpl implements IngredientProductManagerService {

	private IngredientProductDao ingredientProductDao;

	private IngredientProductDominService ingredientProductDominService;

	private BaseProductDao baseProductDao;

	private OrikaBeanMapper orikaBeanMapper;

	@Autowired
	public IngredientProductManagerServiceImpl(IngredientProductDao ingredientProductDao,
			IngredientProductDominService ingredientProductDominService, BaseProductDao baseProductDao,
			OrikaBeanMapper orikaBeanMapper) {
		super();
		this.ingredientProductDao = ingredientProductDao;
		this.ingredientProductDominService = ingredientProductDominService;
		this.baseProductDao = baseProductDao;
		this.orikaBeanMapper = orikaBeanMapper;
	}

	@Override
	public IngredientProductDto addIngredientProduct(IngredientProductDto ingredientProductDto, long idBase) {
		IngredientProduct ingredientProduct = orikaBeanMapper.map(ingredientProductDto, IngredientProduct.class);
		BaseProduct baseProduct = baseProductDao.getOne(idBase);
		return orikaBeanMapper.convertDTO(
				ingredientProductDominService.addIngredientProduct(ingredientProduct, baseProduct),
				IngredientProductDto.class);
	}

	@Override
	public IngredientProductDto editIngredientProduct(IngredientProductDto ingredientProductDto,
			long idIngredientProduct) {
		IngredientProduct ingredientProduct = orikaBeanMapper.map(ingredientProductDto, IngredientProduct.class);
		IngredientProduct existIngredientProduct = ingredientProductDao.getOne(idIngredientProduct);
		return orikaBeanMapper.convertDTO(
				ingredientProductDominService.editIngredientProduct(ingredientProduct, existIngredientProduct),
				IngredientProductDto.class);
	}

	@Override
	public IngredientProductDto findIngredientProduct(long idIngredientProduct) {
		return orikaBeanMapper.convertDTO(ingredientProductDao.getOne(idIngredientProduct), IngredientProductDto.class);
	}

	@Override
	public void deleteIngredientProduct(long idIngredientProduct, long idBase) {
		IngredientProduct existIngredientProduct = ingredientProductDao.getOne(idIngredientProduct);
		BaseProduct baseProduct = baseProductDao.getOne(idBase);
		existIngredientProduct.setBaseProduct(null);
		baseProduct.setIngredientProduct(null);
		ingredientProductDao.delete(existIngredientProduct);
	}

	@Override
	public IngredientProductDto findIngredientProductForBaseProduct(long idBase) {
		BaseProduct baseProduct = baseProductDao.getOne(idBase);
		return orikaBeanMapper.convertDTO(baseProduct.getIngredientProduct(), IngredientProductDto.class);
	}

}
