package org.capiskinserver.domain.hair.service;

import org.capiskinserver.domain.hair.modal.Command;
import org.capiskinserver.security.model.User;
//import org.capiskinserver.security.modal.User;
import org.springframework.stereotype.Service;

@Service
public interface CommandDomainService {

	Command addCommand(Command command, User user);
	
	Command editCommand(Command command, Command existCommand);
	
	Command checkCommandStatus(Command existCommand);
}
