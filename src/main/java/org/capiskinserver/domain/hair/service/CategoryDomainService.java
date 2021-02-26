package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.Category;
import org.capiskinserver.security.modal.User;
import org.springframework.stereotype.Service;

@Service
public interface CategoryDomainService {
	
	Category addCategory(Category category, User user);
	
	Category editCategory(Category category, Category existCategory);

}
