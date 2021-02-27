package org.capiskinserver.application.hair.service;

import java.util.List;

import org.capiskinserver.application.hair.dto.CategoryDto;
import org.springframework.stereotype.Service;

@Service
public interface CategoryManagerService {
	
	CategoryDto addCategory(CategoryDto categoryDto, long idUser);
	
	CategoryDto editCategory(CategoryDto categoryDto, long idCategory);
	
	CategoryDto findCategory(long idCategory);
	
	void deleteCategory(long idCategory);
	
	List<CategoryDto> findCategoriesForUser(long idUser);
	
	List<CategoryDto> findCategories();

}
