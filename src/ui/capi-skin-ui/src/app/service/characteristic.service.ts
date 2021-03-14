import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CharacteristicDto } from '../modal/rest';

@Injectable({
  providedIn: 'root'
})
export class CharacteristicService {
  constructor(private http: HttpClient) {}

  addCharacteristic(characteristicDto: CharacteristicDto, idType: number): Observable<CharacteristicDto> {
    return this.http.post<CharacteristicDto>(
      `http://localhost:8080/api/addCharacteristic/${idType}`,
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
  characteristicNameExists(name: string): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/characteristicNameExists/${name}`);
  }
  addActifToCharacteristic(idCharacteristic: number, idActif: number): Observable<any> {
    return this.http.post<any>(
      `http://localhost:8080/api/addActifToCharacteristic/${idCharacteristic}/${idActif}`,
      null
    );
  }
  removeActifFromCharacteristic(idCharacteristic: number, idActif: number): Observable<any> {
    return this.http.delete<any>(
      `http://localhost:8080/api/removeActifFromCharacteristic/${idCharacteristic}/${idActif}`
    );
  }
  addEssentialToCharacteristic(idCharacteristic: number, idEssential: number): Observable<any> {
    return this.http.post<any>(
      `http://localhost:8080/api/addEssentialToCharacteristic/${idCharacteristic}/${idEssential}`,
      null
    );
  }
  removeEssentialFromCharacteristic(idCharacteristic: number, idEssential: number): Observable<any> {
    return this.http.delete<any>(
      `http://localhost:8080/api/removeEssentialFromCharacteristic/${idCharacteristic}/${idEssential}`
    );
  }
  addProductToCharacteristic(idCharacteristic: number, idIngredient: number): Observable<any> {
    return this.http.post<any>(
      `http://localhost:8080/api/addProductToCharacteristic/${idCharacteristic}/${idIngredient}`,
      null
    );
  }
  removeProductFromCharacteristic(idCharacteristic: number, idIngredient: number): Observable<any> {
    return this.http.delete<any>(
      `http://localhost:8080/api/removeProductFromCharacteristic/${idCharacteristic}/${idIngredient}`
    );
  }
  findProductsForCharacteristic(idCharacteristic: number): Observable<any[]> {
    return this.http.get<any[]>(
      `http://localhost:8080/api/findProductsForCharacteristic/${idCharacteristic}`
    );
  }
  findEssentialOilsForCharacteristic(idCharacteristic: number): Observable<any[]> {
    return this.http.get<any[]>(
      `http://localhost:8080/api/findEssentialOilsForCharacteristic/${idCharacteristic}`
    );
  }
  findActifsForCharacteristic(idCharacteristic: number): Observable<any[]> {
    return this.http.get<any[]>(
      `http://localhost:8080/api/findActifsForCharacteristic/${idCharacteristic}`
    );
  }
}
