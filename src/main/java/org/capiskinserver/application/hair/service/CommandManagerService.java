package org.capiskinserver.application.hair.service;

import java.util.List;

import org.capiskinserver.application.hair.dto.CommandDto;
import org.springframework.stereotype.Service;

@Service
public interface CommandManagerService {
	
	CommandDto addCommand(CommandDto commandDto, long idUser);
	
	CommandDto editCommand(CommandDto commandDto, long idCommand);
	
	CommandDto findCommand(long idCommand);
	
	List<CommandDto> findCommandForUser(long idUser);
	
	List<CommandDto> finCommands();

}
