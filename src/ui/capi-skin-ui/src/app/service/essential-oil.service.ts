import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EssentialOilDto } from '../modal/rest';

@Injectable({
  providedIn: 'root',
})
export class EssentialOilService {
  constructor(private http: HttpClient) { }

  addEssentialOil(
    essentialOilDto: EssentialOilDto
  ): Observable<EssentialOilDto> {
    return this.http.post<EssentialOilDto>(
      `http://localhost:8080/api/addEssentialOil`,
      essentialOilDto
    );
  }
  editEssentialOil(
    essentialOilDto: EssentialOilDto,
    idEssentialOil: number
  ): Observable<EssentialOilDto> {
    return this.http.put<EssentialOilDto>(
      `http://localhost:8080/api/editEssentialOil/${idEssentialOil}`,
      essentialOilDto
    );
  }
  findEssentialOil(idEssentialOil: number): Observable<EssentialOilDto> {
    return this.http.get<EssentialOilDto>(
      `http://localhost:8080/api/findEssentialOil/${idEssentialOil}`
    );
  }
  deleteEssentialOil(idEssentialOil: number): Observable<EssentialOilDto> {
    return this.http.delete<EssentialOilDto>(
      `http://localhost:8080/api/deleteEssentialOil/${idEssentialOil}`
    );
  }
  findEssentialOilForCharar(
    idCharacteristic: number
  ): Observable<EssentialOilDto[]> {
    return this.http.get<EssentialOilDto[]>(
      `http://localhost:8080/api/findEssentialOilForCharar/${idCharacteristic}`
    );
  }
  essentialOilNameExists(name: string): Observable<any> {
    return this.http.get<any>(
      `http://localhost:8080/api/essentialOilNameExists/checkedName/${name}`
    );
  }
  findEssentialOils(): Observable<EssentialOilDto[]> {
    return this.http.get<EssentialOilDto[]>(
      `http://localhost:8080/api/findEssentialOils`
    );
  }
}
