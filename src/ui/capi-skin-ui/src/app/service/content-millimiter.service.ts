import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ContentMillimiterDto } from '../modal/rest';

@Injectable({
  providedIn: 'root',
})
export class ContentMillimiterService {
  constructor(private http: HttpClient) {}

  addContentMillimiter(
    contentMillimiterDto: ContentMillimiterDto,
    idFinalProduct: number
  ): Observable<ContentMillimiterDto> {
    return this.http.post<ContentMillimiterDto>(
      `http://localhost:8080/api/addContentMillimiter/${idFinalProduct}`,
      contentMillimiterDto
    );
  }
  editContentMillimiter(
    contentMillimiterDto: ContentMillimiterDto,
    idContentMillimiter: number
  ): Observable<ContentMillimiterDto> {
    return this.http.put<ContentMillimiterDto>(
      `http://localhost:8080/api/editContentMillimiter/${idContentMillimiter}`,
      contentMillimiterDto
    );
  }
  findContentMillimiter(
    idContentMillimiter: number
  ): Observable<ContentMillimiterDto> {
    return this.http.get<ContentMillimiterDto>(
      `http://localhost:8080/api/findContentMillimiter/${idContentMillimiter}`
    );
  }
  deleteContentMillimiter(
    idContentMillimiter: number
  ): Observable<ContentMillimiterDto> {
    return this.http.delete<ContentMillimiterDto>(
      `http://localhost:8080/api/deleteContentMillimiter/${idContentMillimiter}`
    );
  }
  findContentMillimiterForProduct(
    idFinalProduct: number
  ): Observable<ContentMillimiterDto> {
    return this.http.get<ContentMillimiterDto>(
      `http://localhost:8080/api/findContentMillimiterForProduct/${idFinalProduct}`
    );
  }
}
