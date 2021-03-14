import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AccountDto } from '../../modal/rest';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http: HttpClient) { }

  updateAccount(account: AccountDto, id: number): Observable<AccountDto> {
    return this.http.put<AccountDto>(
      `http://localhost:8080/api/updateAccount/${id}`,
      account
    );
  }
  addAccount(account: AccountDto, idUser: number): Observable<AccountDto> {
    return this.http.post<AccountDto>(
      `http://localhost:8080/api/addAccount/${idUser}`,
      account
    );
  }
  findAccountForUser(idUser: number): Observable<AccountDto> {
    return this.http.get<AccountDto>(`http://localhost:8080/api/findAccountForUser/${idUser}`);
  }
  deleteAccount(idUser: number, idAccount: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/api/deleteAccount/${idUser}/${idAccount}`);
  }
}
