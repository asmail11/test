import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IngredientDto } from '../modal/rest';

@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  constructor(private http: HttpClient) {}

  addIngrdient(ingredientDto: IngredientDto, idFace: number): Observable<IngredientDto> {
    return this.http.post<IngredientDto>(
      `http://localhost:8080/api/addIngrdient/${idFace}`,
      ingredientDto
    );
  }
  editIngrdient(ingredientDto: IngredientDto, idIngrdient: number): Observable<IngredientDto> {
    return this.http.put<IngredientDto>(
      `http://localhost:8080/api/editIngrdient/${idIngrdient}`,
      ingredientDto
    );
  }
  findIngrdient(idIngrdient: number): Observable<IngredientDto> {
    return this.http.get<IngredientDto>(`http://localhost:8080/api/findIngrdient/${idIngrdient}`);
  }
  deleteIngrdient(idIngrdient: number): Observable<IngredientDto> {
    return this.http.delete<IngredientDto>(
      `http://localhost:8080/api/deleteIngrdient/${idIngrdient}`
    );
  }
  findIngrdientsForFaceAndCare(idFace: number): Observable<IngredientDto[]> {
    return this.http.get<IngredientDto[]>(
      `http://localhost:8080/api/findIngrdientsForFaceAndCare/${idFace}`
    );
  }
}
