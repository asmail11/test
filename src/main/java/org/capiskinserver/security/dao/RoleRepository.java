package org.capiskinserver.security.dao;

import java.util.Optional;

import org.capiskinserver.security.modal.Role;
import org.capiskinserver.security.modal.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	 Optional<Role> findByName(RoleName roleName);
}