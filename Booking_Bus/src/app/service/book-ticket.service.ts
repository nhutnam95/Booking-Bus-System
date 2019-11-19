import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';

import { TicketBook } from '../shared/book-ticket';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class BookTicketService {

  bookedTicket: TicketBook;

  private baseUrl = 'http://localhost:8080/book-ticket';
  private statusfilter = 'http://localhost:8080/book-ticket/statusfilter';
  private routefilter ='http://localhost:8080/book-ticket/routefilter';
  private routeandstatusfilter = 'http://localhost:8080/book-ticket/routerandstatusfilter';
 

  constructor(private http: HttpClient) { }

  getBookedTickets(page: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/pages?page=` + page);
  }

  getBookTicketById(id: number): Observable<TicketBook> {
    return this.http.get<TicketBook>(`${this.baseUrl}/get/${id}`);
  }

	 updateStatus(id: number): Observable<any> {
    return this.http.put<TicketBook>(`${this.baseUrl}/update-status?id=` + id, httpOptions);
  }

  searchBookedTicket(idbus, scheduleday, page): Observable<TicketBook[]>{
    return this.http.get<TicketBook[]>(`${this.baseUrl}/get-by-id`, {params: {'idbus': idbus, 'scheduleday': scheduleday, 'page': page}});
  }


  getStatusfilter(idstatus){
    return this.http.get<TicketBook[]>(this.statusfilter,{params:{'idstatus':idstatus}});
  }
  
  getRoutefilter(place){
    return this.http.get<TicketBook[]>(this.routefilter,{params:{'place':place}});
  }

  getRouteandStatusfilter(place,idstatus){
    return this.http.get<TicketBook[]>(this.routeandstatusfilter,{params:{'place':place,'idstatus':idstatus}});
  }
  
 
}
