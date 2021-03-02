
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import { RegisterInfo } from '../modal/RegisterInfo';
import { LoginInfo } from '../modal/LoginInfo';


const httpOptions = {
  headers: new HttpHeaders({'content-Type': 'application/json'}),
};

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  public login(creadentials: LoginInfo): Observable<LoginInfo> {
    return this.http.post<LoginInfo>('http://localhost:8080/api/auth/login', creadentials, httpOptions);
  }
  public signup(info: RegisterInfo): Observable<RegisterInfo> {
    return this.http.post<RegisterInfo>(`http://localhost:8080/api/auth/register`, info, httpOptions);
  }

}
