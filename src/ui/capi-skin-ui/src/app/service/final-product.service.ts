import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FinalProductDto } from '../modal/rest';

@Injectable({
  providedIn: 'root'
})
export class FinalProductService {
  constructor(private http: HttpClient) {}

  addFinalProduct(finalProductDto: FinalProductDto, idIngredients: number, idContent: number): Observable<FinalProductDto> {
    return this.http.post<FinalProductDto>(
      `http://localhost:8080/api/addFinalProduct/${idIngredients}/${idContent}`,
      finalProductDto
    );
  }

  deleteFinalProduct(idFinalProduct: number, idIngredients: number, idContent: number): Observable<FinalProductDto> {
    return this.http.delete<FinalProductDto>(
      `http://localhost:8080/api/deleteFinalProduct/${idFinalProduct}/${idIngredients}/${idContent}`
    );
  }

}
