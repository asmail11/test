import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import { LoginFormDto, SignUpFormDto } from '../../modal/rest';

const httpOptions = {
  headers: new HttpHeaders({'content-Type': 'application/json'}),
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  public updateUser(info: SignUpFormDto, id: number): Observable<SignUpFormDto> {
    return this.http.put<SignUpFormDto>(`http://localhost:8080/api/auth/updateUser/${id}`, info, httpOptions);
  }
  public findAllUsers(): Observable<any[]> {
    return this.http.get<any[]>(`http://localhost:8080/api/auth/findAllUsers`);
  }
  public findUserById(id: number): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/findUserById/${id}`);
  }
  public deleteUser(id: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/api/deleteUser/${id}`);
  }
  public getUserByUsername(username: string): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/auth/getUserByUsername/${username}`);
  }
}
