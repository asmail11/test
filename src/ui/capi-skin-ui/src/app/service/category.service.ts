import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CategoryDto } from '../modal/rest';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  constructor(private http: HttpClient) {}

  addCategory(categoryDto: CategoryDto, idUser: number): Observable<CategoryDto> {
    return this.http.post<CategoryDto>(
      `http://localhost:8080/api/addCategory/${idUser}`,
      categoryDto
    );
  }
  editCategory(categoryDto: CategoryDto, idCategory: number): Observable<CategoryDto> {
    return this.http.put<CategoryDto>(
      `http://localhost:8080/api/editCategory/${idCategory}`,
      categoryDto
    );
  }
  findCategory(idCategory: number): Observable<CategoryDto> {
    return this.http.get<CategoryDto>(`http://localhost:8080/api/findCategory/${idCategory}`);
  }
  deleteCategory(idCategory: number): Observable<CategoryDto> {
    return this.http.delete<CategoryDto>(
      `http://localhost:8080/api/deleteCategory/${idCategory}`
    );
  }
  findCategoriesForUser(idUser: number): Observable<CategoryDto[]> {
    return this.http.get<CategoryDto[]>(
      `http://localhost:8080/api/findCategoriesForUser/${idUser}`
    );
  }
  findCategories(): Observable<CategoryDto[]> {
    return this.http.get<CategoryDto[]>(
      `http://localhost:8080/api/findCategories`
    );
  }
}
