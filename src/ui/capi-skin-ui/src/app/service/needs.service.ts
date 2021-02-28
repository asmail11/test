import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NeedsDto } from '../modal/rest';

@Injectable({
  providedIn: 'root'
})
export class NeedsService {

  constructor(private http: HttpClient) {}

  addNeeds(needsDto: NeedsDto, idCharacteristic: number): Observable<NeedsDto> {
    return this.http.post<NeedsDto>(
      `http://localhost:8080/api/addNeeds/${idCharacteristic}`,
      needsDto
    );
  }
  editNeeds(needsDto: NeedsDto, idNeeds: number): Observable<NeedsDto> {
    return this.http.put<NeedsDto>(
      `http://localhost:8080/api/editNeeds/${idNeeds}`,
      needsDto
    );
  }
  findNeeds(idNeeds: number): Observable<NeedsDto> {
    return this.http.get<NeedsDto>(`http://localhost:8080/api/findNeeds/${idNeeds}`);
  }
  deleteNeeds(idNeeds: number): Observable<NeedsDto> {
    return this.http.delete<NeedsDto>(
      `http://localhost:8080/api/deleteNeeds/${idNeeds}`
    );
  }
  fiNeedsForCharacteristic(idCharacteristic: number): Observable<NeedsDto[]> {
    return this.http.get<NeedsDto[]>(
      `http://localhost:8080/api/fiNeedsForCharacteristic/${idCharacteristic}`
    );
  }
}
