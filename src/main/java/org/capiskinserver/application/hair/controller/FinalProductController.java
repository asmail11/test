
  package org.capiskinserver.application.hair.controller;
  
  import java.util.List;
  
  import org.capiskinserver.application.hair.dto.FinalProductDto; import
  org.capiskinserver.application.hair.service.FinalProductManagerService;
  import org.capiskinserver.util.RestBaseController; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Controller; import
  org.springframework.web.bind.annotation.DeleteMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.RequestBody;
  
  @Controller public class FinalProductController extends RestBaseController {
  
  @Autowired private FinalProductManagerService finalProductManagerService;
  
  @PostMapping("/addFinalProduct/{idIngredients}/{idContent}") FinalProductDto
  addFinalProduct(@RequestBody FinalProductDto finalProductDto, @PathVariable
  List<Long> idIngredients, @PathVariable long idContent) { return
  finalProductManagerService.addFinalProduct(finalProductDto, idIngredients,
  idContent); }
  
  @DeleteMapping(
  "/deleteFinalProduct/{idFinalProduct}/{idIngredient}/{idContent}") void
  deleteFinalProduct(@PathVariable long idFinalProduct, @PathVariable long
  idIngredient, @PathVariable long idContent) {
  finalProductManagerService.deleteFinalProduct(idFinalProduct, idIngredient,
  idContent); } }
 