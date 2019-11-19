import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Status } from '../shared/status';

@Injectable({
  providedIn: 'root'
})
export class StatusSeatService {

  private baseUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  getStatusList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/status-seat-list`);
  }

}
