
  package org.capiskinserver.application.hair.controller;
  
  import org.capiskinserver.application.hair.dto.VegetableOilDto; import
  org.capiskinserver.application.hair.service.VegetableOilManagerService;
  import org.capiskinserver.util.RestBaseController; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Controller; import
  org.springframework.web.bind.annotation.DeleteMapping; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.PutMapping; import
  org.springframework.web.bind.annotation.RequestBody;
  
  @Controller public class VegetableOilController extends RestBaseController {
  
  @Autowired private VegetableOilManagerService vegetableOilManagerService;
  
  @PostMapping("/addVegetableOil/{idCharacteristic}") VegetableOilDto
  addVegetableOil(@RequestBody VegetableOilDto vegetableOilDto, @PathVariable
  long idCharacteristic) { return
  vegetableOilManagerService.addVegetableOil(vegetableOilDto,
  idCharacteristic); }
  
  @PutMapping("/editVegetableOil/{idVegetableOil}") VegetableOilDto
  editVegetableOil(@RequestBody VegetableOilDto vegetableOilDto, @PathVariable
  long idVegetableOil) { return
  vegetableOilManagerService.editVegetableOil(vegetableOilDto, idVegetableOil);
  }
  
  @GetMapping("/findVegetableOil/{idVegetableOil}") VegetableOilDto
  findVegetableOil(@PathVariable long idVegetableOil) { return
  vegetableOilManagerService.findVegetableOil(idVegetableOil); }
  
  @GetMapping("/findVegetableOilForCharacteristic/{idCharacteristic}")
  VegetableOilDto findVegetableOilForCharacteristic(@PathVariable long
  idCharacteristic) { return
  vegetableOilManagerService.findVegetableOilForCharacteristic(idCharacteristic
  ); }
  
  @DeleteMapping("/deleteVegetableOil/{idVegetableOil}/{idCharacteristic}")
  void deleteVegetableOil(@PathVariable long idVegetableOil, @PathVariable long
  idCharacteristic) {
  vegetableOilManagerService.deleteVegetableOil(idVegetableOil,
  idCharacteristic); }
  
  }
 