package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.Actif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActifDao extends JpaRepository<Actif, Long>{
    Boolean existsByName(String checkedName);
}
