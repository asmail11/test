
package org.capiskinserver.security.repository;
import java.util.Optional;

import org.capiskinserver.security.model.Role;
import org.capiskinserver.security.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
