package org.capiskinserver.application.hair.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.capiskinserver.application.hair.dto.CommandDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.CommandDao;
import org.capiskinserver.domain.hair.modal.Command;
import org.capiskinserver.domain.hair.service.CommandDomainService;
import org.capiskinserver.security.dao.UserRepository;
import org.capiskinserver.security.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CommandManagerServiceImpl implements CommandManagerService {

	private CommandDomainService commandDomainService;

	private CommandDao commandDao;

	private UserRepository userRepository;

	private OrikaBeanMapper orikaBeanMapper;

	@Autowired
	public CommandManagerServiceImpl(CommandDomainService commandDomainService, CommandDao commandDao,
			UserRepository userRepository, OrikaBeanMapper orikaBeanMapper) {
		super();
		this.commandDomainService = commandDomainService;
		this.commandDao = commandDao;
		this.userRepository = userRepository;
		this.orikaBeanMapper = orikaBeanMapper;
	}

	@Override
	public CommandDto addCommand(CommandDto commandDto, long idUser) {
		Command command = orikaBeanMapper.map(commandDto, Command.class);
		User user = userRepository.getOne(idUser);
		return orikaBeanMapper.convertDTO(commandDomainService.addCommand(command, user), CommandDto.class);
	}

	@Override
	public CommandDto editCommand(CommandDto commandDto, long idCommand) {
		Command command = orikaBeanMapper.map(commandDto, Command.class);
		Command existCommand = commandDao.getOne(idCommand);
		return orikaBeanMapper.convertDTO(commandDomainService.editCommand(command, existCommand), CommandDto.class);
	}

	@Override
	public CommandDto findCommand(long idCommand) {
		return orikaBeanMapper.convertDTO(commandDao.getOne(idCommand), CommandDto.class);
	}

	@Override
	public List<CommandDto> findCommandForUser(long idUser) {
		User user = userRepository.getOne(idUser);
		List<Command> commands = user.getCommands();
		commands = commands.stream().sorted(Comparator.comparing(Command::getId).reversed())
				.collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(commands, CommandDto.class);
	}

	@Override
	public List<CommandDto> finCommands() {
		List<Command> commands = commandDao.findAll();
		commands = commands.stream().sorted(Comparator.comparing(Command::getId).reversed())
				.collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(commands, CommandDto.class);
	}

	@Override
	public void deleteCommand(long idCommand) {
		Command existCommand = commandDao.getOne(idCommand);
		commandDao.delete(existCommand);
		
	}

}
