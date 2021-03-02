package org.capiskinserver.application.hair.controller;

  import java.util.List;
  
  import org.capiskinserver.application.hair.dto.CategoryDto; import
  org.capiskinserver.application.hair.service.CategoryManagerService; import
  org.capiskinserver.util.RestBaseController; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.security.access.prepost.PreAuthorize; import
  org.springframework.stereotype.Controller; import
  org.springframework.web.bind.annotation.DeleteMapping; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.PutMapping; import
  org.springframework.web.bind.annotation.RequestBody;
  
  @Controller public class CategoryController extends RestBaseController {
  
  @Autowired private CategoryManagerService categoryManagerService;
  
  @PostMapping("/addCategorys/{idUser}")
  
  @PreAuthorize("hasRole('ADMIN') or hasRole('ROLE_ADMIN')") CategoryDto
  addCategory(@RequestBody CategoryDto categoryDto, @PathVariable long idUser)
  { return categoryManagerService.addCategory(categoryDto, idUser); }
  
  @PutMapping("/editCategory/{idCategory}") CategoryDto
  editCategory(@RequestBody CategoryDto categoryDto, @PathVariable long
  idCategory) { return categoryManagerService.editCategory(categoryDto,
  idCategory); }
  
  @GetMapping("/findCategory/{idCategory}") CategoryDto
  findCategory(@PathVariable long idCategory) { return
  categoryManagerService.findCategory(idCategory); }
  
  @DeleteMapping("/deleteCategory/{idCategory}") void
  deleteCategory(@PathVariable long idCategory) {
  categoryManagerService.deleteCategory(idCategory); }
  
  @GetMapping("/findCategoriesForUser/{idUser}") List<CategoryDto>
  findCategoriesForUser(@PathVariable long idUser) { return
  categoryManagerService.findCategoriesForUser(idUser); }
  
  @GetMapping("/findCategories") List<CategoryDto> findCategories() { return
  categoryManagerService.findCategories(); }
  
  }
 
