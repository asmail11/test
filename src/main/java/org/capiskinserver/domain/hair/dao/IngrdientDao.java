package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.Ingrdient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngrdientDao extends JpaRepository<Ingrdient, Long>{

}
