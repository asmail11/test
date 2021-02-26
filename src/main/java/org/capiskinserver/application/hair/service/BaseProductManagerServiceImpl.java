package org.capiskinserver.application.hair.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.capiskinserver.application.hair.dto.BaseProductDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.BaseProductDao;
import org.capiskinserver.domain.hair.dao.NeedsDao;
import org.capiskinserver.domain.hair.modal.BaseProduct;
import org.capiskinserver.domain.hair.modal.Needs;
import org.capiskinserver.domain.hair.service.BaseProductDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BaseProductManagerServiceImpl implements BaseProductManagerService {

	private OrikaBeanMapper orikaBeanMapper;

	private BaseProductDomainService baseProductDomainService;

	private NeedsDao needsDao;

	private BaseProductDao baseProductDao;

	@Autowired
	public BaseProductManagerServiceImpl(OrikaBeanMapper orikaBeanMapper,
			BaseProductDomainService baseProductDomainService, NeedsDao needsDao, BaseProductDao baseProductDao) {
		super();
		this.orikaBeanMapper = orikaBeanMapper;
		this.baseProductDomainService = baseProductDomainService;
		this.needsDao = needsDao;
		this.baseProductDao = baseProductDao;
	}

	@Override
	public BaseProductDto addBaseProduct(BaseProductDto baseProductDto, long idNeeds) {
		BaseProduct baseProduct = orikaBeanMapper.map(baseProductDto, BaseProduct.class);
		Needs needs = needsDao.getOne(idNeeds);
		return orikaBeanMapper.convertDTO(baseProductDomainService.addBaseProduct(baseProduct, needs),
				BaseProductDto.class);
	}

	@Override
	public BaseProductDto editBaseProduct(BaseProductDto baseProductDto, long idBaseProduct) {
		BaseProduct baseProduct = orikaBeanMapper.map(baseProductDto, BaseProduct.class);
		BaseProduct existBaseProduct = baseProductDao.getOne(idBaseProduct);
		return orikaBeanMapper.convertDTO(baseProductDomainService.editBaseProduct(baseProduct, existBaseProduct),
				BaseProductDto.class);
	}

	@Override
	public BaseProductDto findBaseProduct(long idBaseProduct) {
		return orikaBeanMapper.convertDTO(baseProductDao.getOne(idBaseProduct), BaseProductDto.class);
	}

	@Override
	public List<BaseProductDto> finBaseProductForNeeds(long idNeeds) {
		Needs needs = needsDao.getOne(idNeeds);
		List<BaseProduct> baseProducts = needs.getBaseProducts();
		baseProducts = baseProducts.stream().sorted(Comparator.comparing(BaseProduct::getName))
				.collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(baseProducts, BaseProductDto.class);
	}

	@Override
	public void deleteBaseProduct(long idBaseProduct) {
		BaseProduct existBaseProduct = baseProductDao.getOne(idBaseProduct);
		baseProductDao.delete(existBaseProduct);

	};

}
