import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BodyAndHairDto } from '../modal/rest';

@Injectable({
  providedIn: 'root'
})
export class BodyAndHairService {

    constructor(private http: HttpClient) {}

    addAndHair(bodyAndHairDto: BodyAndHairDto, idCategory: number): Observable<BodyAndHairDto> {
      return this.http.post<BodyAndHairDto>(
        `http://localhost:8080/api/addAndHair/${idCategory}`,
        bodyAndHairDto
      );
    }
    editAndHair(bodyAndHairDto: BodyAndHairDto, idBodyAndHair: number): Observable<BodyAndHairDto> {
      return this.http.put<BodyAndHairDto>(
        `http://localhost:8080/api/editAndHair/${idBodyAndHair}`,
        bodyAndHairDto
      );
    }
    findBodyAndHair(idBodyAndHair: number): Observable<BodyAndHairDto> {
      return this.http.get<BodyAndHairDto>(`http://localhost:8080/api/findBodyAndHair/${idBodyAndHair}`);
    }
    deleteBodyAndHair(idBodyAndHair: number): Observable<BodyAndHairDto> {
      return this.http.delete<BodyAndHairDto>(
        `http://localhost:8080/api/deleteBodyAndHair/${idBodyAndHair}`
      );
    }
    findBodyAndHairForCategory(idCategory: number): Observable<BodyAndHairDto[]> {
      return this.http.get<BodyAndHairDto[]>(
        `http://localhost:8080/api/findBodyAndHairForCategory/${idCategory}`
      );
    }
  }

