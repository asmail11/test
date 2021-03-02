package org.capiskinserver.application.hair.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.capiskinserver.application.hair.dto.CategoryDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.CategoryDao;
import org.capiskinserver.domain.hair.modal.Category;
import org.capiskinserver.domain.hair.service.CategoryDomainService;
import org.capiskinserver.security.model.User;
import org.capiskinserver.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryManagerServiceImpl implements CategoryManagerService {

	private CategoryDomainService categoryDomainService;

	private CategoryDao categoryDao;

	private UserRepository userRepository;

	private OrikaBeanMapper orikaBeanMapper;

	@Autowired
	public CategoryManagerServiceImpl(CategoryDomainService categoryDomainService, CategoryDao categoryDao,
			UserRepository userRepository, OrikaBeanMapper orikaBeanMapper) {
		super();
		this.categoryDomainService = categoryDomainService;
		this.categoryDao = categoryDao;
		this.userRepository = userRepository;
		this.orikaBeanMapper = orikaBeanMapper;
	}

	@Override
	public CategoryDto addCategory(CategoryDto categoryDto, long idUser) {
		User user = userRepository.getOne(idUser);
		Category category = orikaBeanMapper.map(categoryDto, Category.class);
		return orikaBeanMapper.convertDTO(categoryDomainService.addCategory(category, user), CategoryDto.class);
	}

	@Override
	public CategoryDto editCategory(CategoryDto categoryDto, long idCategory) {
		Category category = orikaBeanMapper.map(categoryDto, Category.class);
		Category existCategory = categoryDao.getOne(idCategory);
		return orikaBeanMapper.convertDTO(categoryDomainService.editCategory(category, existCategory),
				CategoryDto.class);
	}

	@Override
	public CategoryDto findCategory(long idCategory) {
		return orikaBeanMapper.convertDTO(categoryDao.getOne(idCategory), CategoryDto.class);
	}

	@Override
	public void deleteCategory(long idCategory) {
		Category existCategory = categoryDao.getOne(idCategory);
		categoryDao.delete(existCategory);
	}

	@Override
	public List<CategoryDto> findCategoriesForUser(long idUser) {
		User user = userRepository.getOne(idUser);
		List<Category> categories = user.getCategories();
		categories = categories.stream().sorted(Comparator.comparing(Category::getName)).collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(categories, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> findCategories() {
		List<Category> categories = categoryDao.findAll();
		categories = categories.stream().sorted(Comparator.comparing(Category::getName)).collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(categories, CategoryDto.class);
	}

}
