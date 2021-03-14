import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({'content-Type': 'application/json'}),
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  public updateUser(info: any, id: number): Observable<any> {
    return this.http.put<any>(`http://localhost:8080/api/updateUser/${id}`, info, httpOptions);
  }
  public findAllUsers(): Observable<any[]> {
    return this.http.get<any[]>(`http://localhost:8080/api/findAllUsers`);
  }
  public findUserById(id: number): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/getUserById/${id}`);
  }
  public deleteUser(id: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/api/deleteUser/${id}`);
  }
  public getUserByUsername(username: string): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/getUserByUsername/${username}`);
  }
  public existsByUsername(username: string): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/existsByUsername/${username}`);
  }
  public findUsers(): Observable<any[]> {
    return this.http.get<any[]>(`http://localhost:8080/api/findUsers`);
  }

}

