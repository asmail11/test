package org.capiskinserver.security.service;

import org.capiskinserver.security.dao.UserRepository;
import org.capiskinserver.security.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailServiceimpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userRepository.findUserByEmail(email).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email : " + email));
		return UserDetailsImpl.build(user);
	}
}
