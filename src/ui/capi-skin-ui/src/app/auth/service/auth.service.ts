
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Singin } from '../modal/Singin';
import { SingUp } from '../modal/Singup';
import { of } from 'rxjs';
import { ReplaySubject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  userData: any;

  constructor(private http: HttpClient) {
  }

  signin(singin: Singin): Observable<any> {
    if (singin) {
      this.userData = singin;
      localStorage.setItem('user', JSON.stringify(this.userData));
      JSON.parse(localStorage.getItem('user'));
    } else {
      localStorage.setItem('user', null);
      JSON.parse(localStorage.getItem('user'));
    }
    return this.http.post<any>(`http://localhost:8080/api/auth/signin`, singin);
  }

  signup(singup: SingUp): Observable<any> {
    return this.http.post<any>(`http://localhost:8080/api/auth/signup`, singup);
  }
  get isLoggedIn(): boolean {
    const user = JSON.parse(localStorage.getItem('user'));
    return (user !== null) ? true : false;
  }
  SignOut() {
    localStorage.removeItem('user');
  }
}
