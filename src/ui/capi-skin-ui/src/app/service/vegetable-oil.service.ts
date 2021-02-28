import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { VegetableOilDto } from '../modal/rest';

@Injectable({
  providedIn: 'root'
})
export class VegetableOilService {
  constructor(private http: HttpClient) {}

  addVegetableOil(vegetableOilDto: VegetableOilDto, idCharacteristic: number): Observable<VegetableOilDto> {
    return this.http.post<VegetableOilDto>(
      `http://localhost:8080/api/addVegetableOil/${idCharacteristic}`,
      vegetableOilDto
    );
  }
  editVegetableOil(vegetableOilDto: VegetableOilDto, idVegetableOil: number): Observable<VegetableOilDto> {
    return this.http.put<VegetableOilDto>(
      `http://localhost:8080/api/editVegetableOil/${idVegetableOil}`,
      vegetableOilDto
    );
  }
  findVegetableOil(idVegetableOil: number): Observable<VegetableOilDto> {
    return this.http.get<VegetableOilDto>(`http://localhost:8080/api/findVegetableOil/${idVegetableOil}`);
  }
  deleteActif(idVegetableOil: number): Observable<VegetableOilDto> {
    return this.http.delete<VegetableOilDto>(
      `http://localhost:8080/api/deleteActif/${idVegetableOil}`
    );
  }
  findVegetableOilForCharacteristic(idCharacteristic: number): Observable<VegetableOilDto> {
    return this.http.get<VegetableOilDto>(
      `http://localhost:8080/api/findVegetableOilForCharacteristic/${idCharacteristic}`
    );
  }
}
