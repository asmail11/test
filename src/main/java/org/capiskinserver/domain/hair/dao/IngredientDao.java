package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDao extends JpaRepository<Ingredient, Long>{

}
