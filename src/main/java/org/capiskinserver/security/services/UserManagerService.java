package org.capiskinserver.security.services;

import java.util.List;

import org.capiskinserver.security.model.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserManagerService {
	
	UserDto getUserByUsername(String username);
	
	UserDto updateUser(UserDto userDto, long idUser);
	
	void deleteUser(long idUser);
	
	UserDto getUserById(long idUser);
	
	Boolean existsByUsername(String username);
	
	List<UserDto> findUsers();
	
}
