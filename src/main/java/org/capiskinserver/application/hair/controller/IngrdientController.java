
  package org.capiskinserver.application.hair.controller;
  
  import java.util.List;
  
  import org.capiskinserver.application.hair.dto.IngredientDto; import
  org.capiskinserver.application.hair.service.IngredientManagerService; import
  org.capiskinserver.util.RestBaseController; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Controller; import
  org.springframework.web.bind.annotation.DeleteMapping; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.PutMapping; import
  org.springframework.web.bind.annotation.RequestBody;
  
  @Controller public class IngrdientController extends RestBaseController {
  
  @Autowired private IngredientManagerService ingredientManagerService;
  
  @PostMapping("/addIngrdient/{idFace}") IngredientDto
  addIngrdient(@RequestBody IngredientDto ingrdientDto, @PathVariable long
  idFace) { return ingredientManagerService.addIngrdient(ingrdientDto, idFace);
  }
  
  @PutMapping("/editIngrdient/{idIngrdient}") IngredientDto
  editIngrdient(@RequestBody IngredientDto ingrdientDto, @PathVariable long
  idIngrdient) { return ingredientManagerService.editIngrdient(ingrdientDto,
  idIngrdient); }
  
  @GetMapping("/findIngrdient/{idIngrdient}") IngredientDto
  findIngrdient(@PathVariable long idIngrdient) { return
  ingredientManagerService.findIngrdient(idIngrdient); }
  
  @DeleteMapping("/deleteIngrdient/{idIngrdient}") void
  deleteIngrdient(@PathVariable long idIngrdient) {
  ingredientManagerService.deleteIngrdient(idIngrdient); }
  
  @GetMapping("/findIngrdientsForFaceAndCare/{idFace}") List<IngredientDto>
  findIngrdientsForFaceAndCare(@PathVariable long idFace) { return
  ingredientManagerService.findIngrdientsForFaceAndCare(idFace); }
  
  }
 