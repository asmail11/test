import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ActifDto } from '../modal/rest';

@Injectable({
  providedIn: 'root',
})
export class ActifService {
  constructor(private http: HttpClient) {}

  addActif(actifDto: ActifDto, idCharacteristic: number): Observable<ActifDto> {
    return this.http.post<ActifDto>(
      `http://localhost:8080/api/addActif/${idCharacteristic}`,
      actifDto
    );
  }
  editActif(actifDto: ActifDto, idActif: number): Observable<ActifDto> {
    return this.http.put<ActifDto>(
      `http://localhost:8080/api/editActif/${idActif}`,
      actifDto
    );
  }
  findActif(idActif: number): Observable<ActifDto> {
    return this.http.get<ActifDto>(`http://localhost:8080/api/findActif/${idActif}`);
  }
  deleteActif(idActif: number): Observable<ActifDto> {
    return this.http.delete<ActifDto>(
      `http://localhost:8080/api/deleteActif/${idActif}`
    );
  }
  findActifForCharacteristic(idCharacteristic: number): Observable<ActifDto[]> {
    return this.http.get<ActifDto[]>(
      `http://localhost:8080/api/findActifForCharacteristic/${idCharacteristic}`
    );
  }
}
