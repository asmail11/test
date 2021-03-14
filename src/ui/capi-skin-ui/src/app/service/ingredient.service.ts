import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IngredientDto } from '../modal/rest';

@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  constructor(private http: HttpClient) {}

  addIngredient(ingredientDto: IngredientDto): Observable<IngredientDto> {
    return this.http.post<IngredientDto>(
      `http://localhost:8080/api/addIngredient`,
      ingredientDto
    );
  }
  editIngredient(ingredientDto: IngredientDto, idIngrdient: number): Observable<IngredientDto> {
    return this.http.put<IngredientDto>(
      `http://localhost:8080/api/editIngredient/${idIngrdient}`,
      ingredientDto
    );
  }
  findIngredient(idIngrdient: number): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/findIngredient/${idIngrdient}`);
  }
  deleteIngredient(idIngrdient: number): Observable<IngredientDto> {
    return this.http.delete<any>(
      `http://localhost:8080/api/deleteIngredient/${idIngrdient}`
    );
  }
  findIngrdientsForFaceAndCare(idFace: number): Observable<IngredientDto[]> {
    return this.http.get<IngredientDto[]>(
      `http://localhost:8080/api/findIngrdientsForFaceAndCare/${idFace}`
    );
  }
  ingredientNameExists(checkedName: string): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/ingredientNameExists/${checkedName}`);
  }
  findIngredients(): Observable<IngredientDto[]> {
    return this.http.get<IngredientDto[]>(`http://localhost:8080/api/findIngredients`);
  }

}
