import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BaseProductDto } from '../modal/rest';

@Injectable({
  providedIn: 'root'
})
export class BaseProductService {

  constructor(private http: HttpClient) {}

  addBaseProduct(baseProductDto: BaseProductDto, idNeeds: number): Observable<BaseProductDto> {
    return this.http.post<BaseProductDto>(
      `http://localhost:8080/api/addBaseProduct/${idNeeds}`,
      baseProductDto
    );
  }
  editBaseProduct(baseProductDto: BaseProductDto, idActif: number): Observable<BaseProductDto> {
    return this.http.put<BaseProductDto>(
      `http://localhost:8080/api/editBaseProduct/${idActif}`,
      baseProductDto
    );
  }
  findBaseProduct(idActif: number): Observable<BaseProductDto> {
    return this.http.get<BaseProductDto>(`http://localhost:8080/api/findBaseProduct/${idActif}`);
  }
  deleteBaseProduct(idBaseProduct: number): Observable<BaseProductDto> {
    return this.http.delete<BaseProductDto>(
      `http://localhost:8080/api/deleteBaseProduct/${idBaseProduct}`
    );
  }
  finBaseProductForNeeds(idNeeds: number): Observable<BaseProductDto[]> {
    return this.http.get<BaseProductDto[]>(
      `http://localhost:8080/api/finBaseProductForNeeds/${idNeeds}`
    );
  }
}
