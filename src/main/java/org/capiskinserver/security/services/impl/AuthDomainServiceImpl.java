package org.capiskinserver.security.services.impl;

import org.capiskinserver.security.model.User;
import org.capiskinserver.security.repository.UserRepository;
import org.capiskinserver.security.services.AuthDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthDomainServiceImpl implements AuthDomainService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;


	@Override
	public User updateUser(User user, User existUser) {
		if (user != null && existUser != null) {
			existUser.setUsername(user.getUsername());
			existUser.setEmail(user.getEmail());
			existUser.setPassword(encoder.encode(user.getPassword()));
			return userRepository.save(existUser);
		}
		return null;
	}

}
