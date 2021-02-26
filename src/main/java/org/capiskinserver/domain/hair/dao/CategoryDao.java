package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long>{

}
