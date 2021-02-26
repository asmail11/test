package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.CommandDao;
import org.capiskinserver.domain.hair.modal.Command;
import org.capiskinserver.security.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandDomainServiceImpl implements CommandDomainService {

	@Autowired
	private CommandDao commandDao;

	@Override
	public Command addCommand(Command command, User user) {
		if (command != null && user != null) {
			command.setCreatedAt(new Date());
			command.setStatus(false);
			user.addCommand(command);
			return commandDao.save(command);
		}
		return null;
	}

	@Override
	public Command editCommand(Command command, Command existCommand) {
		if (command != null && existCommand != null) {
			existCommand.setCreatedAt(null);
			existCommand.setUpdatedAt(new Date());
			existCommand.setProductName(command.getProductName());
			existCommand.setBaseProduct(command.getBaseProduct());
			existCommand.setTotal(command.getTotal());
			return commandDao.save(existCommand);
		}
		return null;
	}

	@Override
	public Command checkCommandStatus(Command existCommand) {
		if (existCommand != null) {
			existCommand.setStatus(true);
			return commandDao.save(existCommand);
		}
		return null;
	}

}
