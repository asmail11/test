import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IngredientProductDto } from '../modal/rest';

@Injectable({
  providedIn: 'root'
})
export class IngredientProductService {

  constructor(private http: HttpClient) {}

  addIngredientProduct(ingredientProductDto: IngredientProductDto, idBase: number): Observable<IngredientProductDto> {
    return this.http.post<IngredientProductDto>(
      `http://localhost:8080/api/addIngredientProduct/${idBase}`,
      ingredientProductDto
    );
  }
  editIngredientProduct(ingredientProductDto: IngredientProductDto, idIngrdient: number): Observable<IngredientProductDto> {
    return this.http.put<IngredientProductDto>(
      `http://localhost:8080/api/editIngredientProduct/${idIngrdient}`,
      ingredientProductDto
    );
  }
  findIngredientProduct(idIngrdient: number): Observable<IngredientProductDto> {
    return this.http.get<IngredientProductDto>(`http://localhost:8080/api/findIngredientProduct/${idIngrdient}`);
  }
  deleteIngredientProduct(idIngrdient: number, idbase: number): Observable<IngredientProductDto> {
    return this.http.delete<IngredientProductDto>(
      `http://localhost:8080/api/deleteIngredientProduct/${idIngrdient}/${idbase}`
    );
  }
  findIngredientProductForBaseProduct(idBase: number): Observable<IngredientProductDto[]> {
    return this.http.get<IngredientProductDto[]>(
      `http://localhost:8080/api/findIngredientProductForBaseProduct/${idBase}`
    );
  }
}
