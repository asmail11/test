package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.CategoryDao;
import org.capiskinserver.domain.hair.modal.Category;
import org.capiskinserver.exception.AlreadyExistsException;
import org.capiskinserver.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryDomainServiceImpl implements CategoryDomainService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Category addCategory(Category category, User user) {
		/*
		 * if (user.hasCategory(category.getName())) { throw new
		 * AlreadyExistsException("\n The name of category has be unique \n"); }
		 */
		if (category != null && user != null) {
			category.setCreatedAt(new Date());
			user.addCategory(category);
			return categoryDao.save(category);
		}
		return null;
	}

	@Override
	public Category editCategory(Category category, Category existCategory) {
		if (category != null && existCategory != null) {
			existCategory.setCreatedAt(null);
			existCategory.setUpdatedAt(new Date());
			existCategory.setName(category.getName());
			category.setDescription(existCategory.getDescription());
			return categoryDao.save(existCategory);
		}
		return null;
	}

}
