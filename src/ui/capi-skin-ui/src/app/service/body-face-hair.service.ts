import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BodyFaceHairDto } from '../modal/rest';

@Injectable({
  providedIn: 'root'
})
export class BodyFaceHairService {

    constructor(private http: HttpClient) {}

    addBodyFaceHair(bodyAndHairDto: BodyFaceHairDto): Observable<BodyFaceHairDto> {
      return this.http.post<BodyFaceHairDto>(
        `http://localhost:8080/api/addBodyFaceHair`,
        bodyAndHairDto
      );
    }
    editBodyFaceHair(bodyAndHairDto: BodyFaceHairDto, idBodyAndHair: number): Observable<BodyFaceHairDto> {
      return this.http.put<BodyFaceHairDto>(
        `http://localhost:8080/api/editBodyFaceHair/${idBodyAndHair}`,
        bodyAndHairDto
      );
    }
    findBodyFaceHair(idBodyAndHair: number): Observable<BodyFaceHairDto> {
      return this.http.get<BodyFaceHairDto>(`http://localhost:8080/api/findBodyFaceHair/${idBodyAndHair}`);
    }
    deleteBodyFaceHair(idBodyAndHair: number): Observable<BodyFaceHairDto> {
      return this.http.delete<BodyFaceHairDto>(
        `http://localhost:8080/api/deleteBodyFaceHair/${idBodyAndHair}`
      );
    }
    findBodyFaceHairs(): Observable<BodyFaceHairDto[]> {
      return this.http.get<BodyFaceHairDto[]>(
        `http://localhost:8080/api/findBodyFaceHairs`
      );
    }

    bodyAndHairNameExists(checkedName: string): Observable<any> {
      return this.http.get<any>(`http://localhost:8080/api/bodyAndHairNameExists/checkedName/${checkedName}`);
    }
  }

