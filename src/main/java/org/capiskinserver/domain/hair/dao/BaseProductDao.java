package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.BaseProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseProductDao extends JpaRepository<BaseProduct, Long> {
    boolean existsByName(String checkedName);
}
