import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FaceAndCareDto } from '../modal/rest';

@Injectable({
  providedIn: 'root'
})
export class FaceAndCareService {

  constructor(private http: HttpClient) {}

  addFaceAndCare(faceAndCareDto: FaceAndCareDto, idBody: number): Observable<FaceAndCareDto> {
    return this.http.post<FaceAndCareDto>(
      `http://localhost:8080/api/addFaceAndCare/${idBody}`,
      faceAndCareDto
    );
  }
  editFaceAndCare(faceAndCareDto: FaceAndCareDto, idFaceAndCare: number): Observable<FaceAndCareDto> {
    return this.http.put<FaceAndCareDto>(
      `http://localhost:8080/api/editFaceAndCare/${idFaceAndCare}`,
      faceAndCareDto
    );
  }
  findFaceAndCare(idFaceAndCare: number): Observable<FaceAndCareDto> {
    return this.http.get<FaceAndCareDto>(`http://localhost:8080/api/findFaceAndCare/${idFaceAndCare}`);
  }
  deleteFaceAndCare(idFaceAndCare: number): Observable<FaceAndCareDto> {
    return this.http.delete<FaceAndCareDto>(
      `http://localhost:8080/api/deleteFaceAndCare/${idFaceAndCare}`
    );
  }
  findFaceAndCareForBodyAndHair(idBody: number): Observable<FaceAndCareDto[]> {
    return this.http.get<FaceAndCareDto[]>(
      `http://localhost:8080/api/findFaceAndCareForBodyAndHair/${idBody}`
    );
  }
}
