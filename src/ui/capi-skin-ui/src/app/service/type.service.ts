import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TypeDto } from '../modal/rest';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({'content-Type': 'application/json'}),
};

@Injectable({
  providedIn: 'root'
})
export class TypeService {
  constructor(private http: HttpClient) { }

  addType(type: TypeDto, idBody: number): Observable<TypeDto> {
    return this.http.post<TypeDto>(
      `http://localhost:8080/api/addType/${idBody}`,
      type
    );
  }
  editType(type: TypeDto, idType: number): Observable<TypeDto> {
    return this.http.put<TypeDto>(
      `http://localhost:8080/api/editType/${idType}`,
      type
    );
  }
  findType(idType: number): Observable<TypeDto> {
    return this.http.get<TypeDto>(`http://localhost:8080/api/findType/${idType}`);
  }

  deleteType(idType: number): Observable<TypeDto> {
    return this.http.delete<TypeDto>(
      `http://localhost:8080/api/deleteType/${idType}`
    );
  }

  typeNameExists(checkedName: string): Observable<TypeDto> {
    return this.http.get<TypeDto>(`http://localhost:8080/api/typeNameExists/checkedName/${checkedName}`);
  }

}
