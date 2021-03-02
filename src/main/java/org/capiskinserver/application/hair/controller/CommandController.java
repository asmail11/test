
  package org.capiskinserver.application.hair.controller;
  
  import java.util.List;
  
  import org.capiskinserver.application.hair.dto.CommandDto; import
  org.capiskinserver.application.hair.service.CommandManagerService; import
  org.capiskinserver.util.RestBaseController; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Controller; import
  org.springframework.web.bind.annotation.DeleteMapping; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.PutMapping; import
  org.springframework.web.bind.annotation.RequestBody;
  
  @Controller public class CommandController extends RestBaseController {
  
  @Autowired private CommandManagerService commandManagerService;
  
  @PostMapping("/addCommand/{idUser}") CommandDto addCommand(@RequestBody
  CommandDto commandDto, @PathVariable long idUser) { return
  commandManagerService.addCommand(commandDto, idUser); }
  
  @PutMapping("/editCommand/{idCommand}") CommandDto editCommand(@RequestBody
  CommandDto commandDto, @PathVariable long idCommand) { return
  commandManagerService.editCommand(commandDto, idCommand); }
  
  @GetMapping("/findCommand/{idCommand}") CommandDto findCommand(@PathVariable
  long idCommand) { return commandManagerService.findCommand(idCommand); }
  
  @GetMapping("/findCommandForUser/{idUser}") List<CommandDto>
  findCommandForUser(@PathVariable long idUser) { return
  commandManagerService.findCommandForUser(idUser); }
  
  @GetMapping("/finCommands") List<CommandDto> finCommands() { return
  commandManagerService.finCommands(); }
  
  @DeleteMapping("/deleteCommand/{idCommand}") void deleteCommand(@PathVariable
  long idCommand) { commandManagerService.deleteCommand(idCommand); } }
 