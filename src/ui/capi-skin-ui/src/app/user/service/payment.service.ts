import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PaymentDto } from '../../modal/rest';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http: HttpClient) { }

  addPayment(payment: PaymentDto, idUser: number): Observable<PaymentDto> {
    return this.http.post<PaymentDto>(
      `http://localhost:8080/api/addPayment/${idUser}`,
      payment
    );
  }
  updatePayment(payment: PaymentDto, idPayment: number): Observable<PaymentDto> {
    return this.http.put<PaymentDto>(
      `http://localhost:8080/api/updatePayment/${idPayment}`,
      payment
    );
  }
  findPaymentForUser(idUser: number): Observable<PaymentDto> {
    return this.http.get<PaymentDto>(`http://localhost:8080/api/findPaymentForUser/${idUser}`);
  }
  validatedCreditCardNumber(cartNumber: string): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/validatedCreditCardNumber/${cartNumber}`);
  }
  deletePayment(idUser: number, idPayment: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/api/deletePayment/${idUser}/${idPayment}`);
  }
}
