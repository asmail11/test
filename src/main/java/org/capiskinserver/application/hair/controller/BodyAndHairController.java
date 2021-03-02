package org.capiskinserver.application.hair.controller;


  import java.util.List;
  
  import org.capiskinserver.application.hair.dto.BodyAndHairDto; import
  org.capiskinserver.application.hair.service.BodyAndHairManagerService; import
  org.capiskinserver.util.RestBaseController; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Controller; import
  org.springframework.web.bind.annotation.DeleteMapping; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.PutMapping; import
  org.springframework.web.bind.annotation.RequestBody;
  
  @Controller public class BodyAndHairController extends RestBaseController {
  
  @Autowired private BodyAndHairManagerService bodyAndHairManagerService;
  
  @PostMapping("/addAndHair/{idCategory}") BodyAndHairDto
  addAndHair(@RequestBody BodyAndHairDto bodyAndHairDto, @PathVariable long
  idCategory) { return bodyAndHairManagerService.addAndHair(bodyAndHairDto,
  idCategory); }
  
  @PutMapping("/editAndHair/{idBodyAndHair}") BodyAndHairDto
  editAndHair(@RequestBody BodyAndHairDto bodyAndHairDto, @PathVariable long
  idBodyAndHair) { return bodyAndHairManagerService.editAndHair(bodyAndHairDto,
  idBodyAndHair); }
  
  @GetMapping("/findBodyAndHair/{idBodyAndHair}") BodyAndHairDto
  findBodyAndHair(@PathVariable long idBodyAndHair) { return
  bodyAndHairManagerService.findBodyAndHair(idBodyAndHair); }
  
  @DeleteMapping("/deleteBodyAndHair/{idBodyAndHair}") void
  deleteBodyAndHair(@PathVariable long idBodyAndHair) {
  bodyAndHairManagerService.deleteBodyAndHair(idBodyAndHair); }
  
  @GetMapping("/findBodyAndHairForCategory/{idCategory}") List<BodyAndHairDto>
  findBodyAndHairForCategory(@PathVariable long idCategory) { return
  bodyAndHairManagerService.findBodyAndHairForCategory(idCategory); }
  
  }
 
