package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.FinalProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalProductDao extends JpaRepository<FinalProduct, Long>{

}
