
  package org.capiskinserver.application.hair.controller;
  
  import java.util.List;
  
  import org.capiskinserver.application.hair.dto.FaceAndCareDto; import
  org.capiskinserver.application.hair.service.FaceAndCareManagerService; import
  org.capiskinserver.util.RestBaseController; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Controller; import
  org.springframework.web.bind.annotation.DeleteMapping; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.PutMapping; import
  org.springframework.web.bind.annotation.RequestBody;
  
  @Controller public class FaceAndCare extends RestBaseController {
  
  @Autowired private FaceAndCareManagerService faceAndCareManagerService;
  
  @PostMapping("/addFaceAndCare/{idBody}") FaceAndCareDto
  addFaceAndCare(@RequestBody FaceAndCareDto faceAndCareDto, @PathVariable long
  idBody) { return faceAndCareManagerService.addFaceAndCare(faceAndCareDto,
  idBody); }
  
  @PutMapping("/editFaceAndCare/{idFaceAndCare}") FaceAndCareDto
  editFaceAndCare(@RequestBody FaceAndCareDto faceAndCareDto, @PathVariable
  long idFaceAndCare) { return
  faceAndCareManagerService.editFaceAndCare(faceAndCareDto, idFaceAndCare); }
  
  @GetMapping("/findFaceAndCare/{idFaceAndCare}") FaceAndCareDto
  findFaceAndCare(@PathVariable long idFaceAndCare) { return
  faceAndCareManagerService.findFaceAndCare(idFaceAndCare); }
  
  @DeleteMapping("/deleteFaceAndCare/{idFaceAndCare}") void
  deleteFaceAndCare(@PathVariable long idFaceAndCare) {
  faceAndCareManagerService.deleteFaceAndCare(idFaceAndCare); }
  
  @GetMapping("/findFaceAndCareForBodyAndHair/{idBody}") List<FaceAndCareDto>
  findFaceAndCareForBodyAndHair(@PathVariable long idBody) { return
  faceAndCareManagerService.findFaceAndCareForBodyAndHair(idBody); }
  
  }
 