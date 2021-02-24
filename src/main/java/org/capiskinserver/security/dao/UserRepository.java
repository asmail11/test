package org.capiskinserver.security.dao;

import java.util.Optional;

import org.capiskinserver.security.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findUserByEmail(String email);

	Optional<User> findUserByname(String name);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
