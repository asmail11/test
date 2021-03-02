
  package org.capiskinserver.application.hair.controller;
  
  import org.capiskinserver.application.hair.dto.EssentialOilDto; import
  org.capiskinserver.application.hair.service.EssentialOilManagerService;
  import org.capiskinserver.util.RestBaseController; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Controller; import
  org.springframework.web.bind.annotation.DeleteMapping; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.PutMapping; import
  org.springframework.web.bind.annotation.RequestBody;
  
  @Controller public class EssentialOiController extends RestBaseController {
  
  @Autowired private EssentialOilManagerService essentialOilManagerService;
  
  @PostMapping("/addEssentialOil/{idCharar}") EssentialOilDto
  addEssentialOil(@RequestBody EssentialOilDto essentialOilDto, @PathVariable
  long idCharar) { return
  essentialOilManagerService.addEssentialOil(essentialOilDto, idCharar); }
  
  @PutMapping("/editEssentialOil/{idEssentialOil}") EssentialOilDto
  editEssentialOil(@RequestBody EssentialOilDto essentialOilDto, @PathVariable
  long idEssentialOil) { return
  essentialOilManagerService.editEssentialOil(essentialOilDto, idEssentialOil);
  }
  
  @GetMapping("/findEssentialOil/{idEssentialOil}") EssentialOilDto
  findEssentialOil(@PathVariable long idEssentialOil) { return
  essentialOilManagerService.findEssentialOil(idEssentialOil); }
  
  @GetMapping("/findEssentialOilForCharar/{idCharar}") EssentialOilDto
  findEssentialOilForCharar(@PathVariable long idCharar) { return
  essentialOilManagerService.findEssentialOilForCharar(idCharar); }
  
  @DeleteMapping("/deleteEssentialOil/{idEssentialOil}/{idCharar}") void
  deleteEssentialOil(@PathVariable long idEssentialOil, @PathVariable long
  idCharar) { essentialOilManagerService.deleteEssentialOil(idEssentialOil,
  idCharar); }
  
  }
 