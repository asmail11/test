package org.capiskinserver.security.services;

import org.capiskinserver.security.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthDomainService {

	User updateUser(User user, User existUser);
}
