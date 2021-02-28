import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CharacteristicDto } from '../modal/rest';

@Injectable({
  providedIn: 'root'
})
export class CharacteristicService {
  constructor(private http: HttpClient) {}

  addCharacteristic(characteristicDto: CharacteristicDto, idCategory: number): Observable<CharacteristicDto> {
    return this.http.post<CharacteristicDto>(
      `http://localhost:8080/api/addCharacteristic/${idCategory}`,
      characteristicDto
    );
  }
  editCharacteristic(characteristicDto: CharacteristicDto, idCharacteristic: number): Observable<CharacteristicDto> {
    return this.http.put<CharacteristicDto>(
      `http://localhost:8080/api/editCharacteristic/${idCharacteristic}`,
      characteristicDto
    );
  }
  findCharacteristic(idCharacteristic: number): Observable<CharacteristicDto> {
    return this.http.get<CharacteristicDto>(`http://localhost:8080/api/findCharacteristic/${idCharacteristic}`);
  }
  deleteCharacteristic(idCharacteristic: number): Observable<CharacteristicDto> {
    return this.http.delete<CharacteristicDto>(
      `http://localhost:8080/api/deleteCharacteristic/${idCharacteristic}`
    );
  }
  finCharacteristicForCategory(idCategory: number): Observable<CharacteristicDto[]> {
    return this.http.get<CharacteristicDto[]>(
      `http://localhost:8080/api/finCharacteristicForCategory/${idCategory}`
    );
  }
}
