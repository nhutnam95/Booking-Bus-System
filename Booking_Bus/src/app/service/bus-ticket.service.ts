import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';

import { BusTicket } from '../shared/bus-ticket';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class BusTicketService {

  private baseUrl = 'http://localhost:8080/bus-ticket';

  constructor(private http: HttpClient) { }

  getTicketsList(page: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/tickets?page=` + page);
  }

  getTicket(id: number): Observable<BusTicket> {
    return this.http.get<BusTicket>(`${this.baseUrl}/get/${id}`);
  }

  updateStatusTicket(ticket: BusTicket): Observable<any> {
    return this.http.put(`${this.baseUrl}/update/${ticket.idticket}`, ticket, httpOptions);
  }

  findTicket(idbus, scheduleday, page): Observable<BusTicket[]> {
    return this.http.get<BusTicket[]>(`${this.baseUrl}/find-ticket`, { params: { 'idbus': idbus, 'scheduleday': scheduleday, 'page': page } });
  }
}
