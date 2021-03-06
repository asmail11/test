package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.Needs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeedsDao extends JpaRepository<Needs, Long>{
    boolean existsByName(String checkedName);
}
