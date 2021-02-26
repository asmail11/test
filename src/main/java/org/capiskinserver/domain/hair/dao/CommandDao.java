package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandDao extends JpaRepository<Command, Long>{

}
