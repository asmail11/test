import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ActifDto } from '../modal/rest';

@Injectable({
  providedIn: 'root',
})
export class ActifService {
  constructor(private http: HttpClient) {}

  addActif(actifDto: ActifDto): Observable<ActifDto> {
    return this.http.post<ActifDto>(
      `http://localhost:8080/api/addActif`,
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
  finActifs(): Observable<any[]> {
    return this.http.get<any[]>(`http://localhost:8080/api/finActifs`);
  }
  deleteActif(idActif: number): Observable<ActifDto> {
    return this.http.delete<ActifDto>(
      `http://localhost:8080/api/deleteActif/${idActif}`
    );
  }

  actifNameExists(checkedName: string): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/actifNameExists/checkedName/${checkedName}`);
  }
}
