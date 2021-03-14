package org.capiskinserver.application.hair.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.capiskinserver.application.hair.dto.ProductDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.ProductDao;
import org.capiskinserver.domain.hair.modal.Product;
import org.capiskinserver.domain.hair.service.ProductDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductManagerServiceImpl implements ProductManagerService {

	private OrikaBeanMapper orikaBeanMapper;

	private ProductDomainService productDomainService;

	private ProductDao productDao;

	@Autowired
	public ProductManagerServiceImpl(OrikaBeanMapper orikaBeanMapper, ProductDomainService productDomainService,
			ProductDao productDao) {
		super();
		this.orikaBeanMapper = orikaBeanMapper;
		this.productDomainService = productDomainService;
		this.productDao = productDao;
	}

	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product product = orikaBeanMapper.map(productDto, Product.class);
		return orikaBeanMapper.convertDTO(productDomainService.addProduct(product), ProductDto.class);
	}

	@Override
	public ProductDto editProduct(ProductDto productDto, long idProduct) {
		Product product = orikaBeanMapper.map(productDto, Product.class);
		Product existProduct = productDao.getOne(idProduct);
		return orikaBeanMapper.convertDTO(productDomainService.editProduct(product, existProduct), ProductDto.class);
	}

	@Override
	public ProductDto findProduct(long id) {
		return orikaBeanMapper.convertDTO(productDao.getOne(id), ProductDto.class);
	}

	@Override
	public void deleteProduct(long id) {
		Product existProduct = productDao.getOne(id);
		productDao.delete(existProduct);
	}

	@Override
	public List<ProductDto> findProducts() {
		List<Product> products = productDao.findAll();
		products = products.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(products, ProductDto.class);
	}

	@Override
	public boolean productNameExists(String name) {
		return productDao.existsByName(name);
	}

}
