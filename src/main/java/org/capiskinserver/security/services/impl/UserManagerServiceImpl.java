package org.capiskinserver.security.services.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.security.model.User;
import org.capiskinserver.security.model.UserDto;
import org.capiskinserver.security.repository.UserRepository;
import org.capiskinserver.security.services.AuthDomainService;
import org.capiskinserver.security.services.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserManagerServiceImpl implements UserManagerService {
	
	private UserRepository userRepository;
	
	private OrikaBeanMapper orikaBeanMapper;
	
	private AuthDomainService authDomainService;

	@Autowired
	public UserManagerServiceImpl(UserRepository userRepository, OrikaBeanMapper orikaBeanMapper,
			AuthDomainService authDomainService) {
		super();
		this.userRepository = userRepository;
		this.orikaBeanMapper = orikaBeanMapper;
		this.authDomainService = authDomainService;
	}

	@Override
	public UserDto getUserByUsername(String username) {
		   Optional<User> user = userRepository.findByUsername(username);
	        if (user.isPresent()) {
	            User user1 = user.get();
	            return orikaBeanMapper.convertDTO(user1, UserDto.class);
	        }
	        return null;
	}

	@Override
	public UserDto updateUser(UserDto userDto, long idUser) {
	    User user = orikaBeanMapper.convertDTO(userDto, User.class);
	    User existUser = userRepository.getOne(idUser);
		return orikaBeanMapper.convertDTO(authDomainService.updateUser(user, existUser), UserDto.class);
	}

	@Override
	public void deleteUser(long idUser) {
	userRepository.deleteById(idUser);
		
	}

	@Override
	public UserDto getUserById(long idUser) {
		return orikaBeanMapper.convertDTO(userRepository.getOne(idUser), UserDto.class);
	}

	@Override
	public Boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public List<UserDto> findUsers() {
		List<User> users = userRepository.findAll();
		users = users.stream().sorted(Comparator.comparing(User::getUsername))
				.collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(users, UserDto.class);
	}
	
	

}
