
  package org.capiskinserver.application.hair.controller;
  
  import java.util.List;
  
  import org.capiskinserver.application.hair.dto.CharacteristicDto; import
  org.capiskinserver.application.hair.service.CharacteristicManagerService;
  import org.capiskinserver.util.RestBaseController; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Controller; import
  org.springframework.web.bind.annotation.DeleteMapping; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.PutMapping; import
  org.springframework.web.bind.annotation.RequestBody;
  
  @Controller public class CharacteristicController extends RestBaseController
  {
  
  @Autowired private CharacteristicManagerService characteristicManagerService;
  
  @PostMapping("/addCharacteristic/{idCategory}") CharacteristicDto
  addCharacteristic(@RequestBody CharacteristicDto characteristicDto,
  
  @PathVariable long idCategory) { return
  characteristicManagerService.addCharacteristic(characteristicDto,
  idCategory); }
  
  @PutMapping("/editCharacteristic/{idCharacteristic}") CharacteristicDto
  editCharacteristic(@RequestBody CharacteristicDto characteristicDto,
  
  @PathVariable long idCharacteristic) { return
  characteristicManagerService.editCharacteristic(characteristicDto,
  idCharacteristic); }
  
  @GetMapping("/findCharacteristic/{idCharacteristic}") CharacteristicDto
  findCharacteristic(@PathVariable long idCharacteristic) { return
  characteristicManagerService.findCharacteristic(idCharacteristic); }
  
  @DeleteMapping("/deleteCharacteristic/{idCharacteristic}") void
  deleteCharacteristic(@PathVariable long idCharacteristic) {
  characteristicManagerService.deleteCharacteristic(idCharacteristic); }
  
  @GetMapping("/finCharacteristicForCategory/{idCategory}")
  List<CharacteristicDto> finCharacteristicForCategory(@PathVariable long
  idCategory) { return
  characteristicManagerService.finCharacteristicForCategory(idCategory); }
  
  }
 