import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CommandDto } from '../modal/rest';

@Injectable({
  providedIn: 'root'
})
export class CommandService {
  constructor(private http: HttpClient) {}

  addCommand(commandDto: CommandDto, idCommand: number): Observable<CommandDto> {
    return this.http.post<CommandDto>(
      `http://localhost:8080/api/addCommand/${idCommand}`,
      commandDto
    );
  }
  editCommand(commandDto: CommandDto, idCommand: number): Observable<CommandDto> {
    return this.http.put<CommandDto>(
      `http://localhost:8080/api/editCommand/${idCommand}`,
      commandDto
    );
  }
  findCommand(idCommand: number): Observable<CommandDto> {
    return this.http.get<CommandDto>(`http://localhost:8080/api/findCommand/${idCommand}`);
  }
  deleteCommand(idCommand: number): Observable<CommandDto> {
    return this.http.delete<CommandDto>(
      `http://localhost:8080/api/deleteCommand/${idCommand}`
    );
  }
  findCommandForUser(idUser: number): Observable<CommandDto[]> {
    return this.http.get<CommandDto[]>(
      `http://localhost:8080/api/findCommandForUser/${idUser}`
    );
  }
  finCommands(): Observable<CommandDto[]> {
    return this.http.get<CommandDto[]>(
      `http://localhost:8080/api/finCommands`
    );
  }
}
