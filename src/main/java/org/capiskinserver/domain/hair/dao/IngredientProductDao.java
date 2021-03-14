package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.IngredientProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientProductDao extends JpaRepository<IngredientProduct, Long> {
    boolean existsByName(String checkedName);
}
