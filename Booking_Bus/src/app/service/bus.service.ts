import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Bus } from '../shared/bus';
import {BusTicket} from '../shared/bus-ticket';
import {Route} from '../shared/route';
import {TicketBook} from '../shared/book-ticket'

@Injectable({
  providedIn: 'root'
})
export class BusService {

  constructor(
    private http: HttpClient
  ) { }
  bus: Bus[];
  busTicket:BusTicket[];
  route:Route[];
  ticketbook:TicketBook[];

  private busUrl = 'http://localhost:8080/buses';

  private busUrl1 = 'http://localhost:8080/findbus';

  private busdetail = 'http://localhost:8080/detail';

  private bookticketUrl = 'http://localhost:8080/seat';

  private routeUrl = 'http://localhost:8080/route';

  private routebusUrl ='http://localhost:8080/routeandbus';

  private bookUrl ='http://localhost:8080/bookticket';

  private usersticket ='http://localhost:8080/ticketusers';

  private cancleticketUrl ='http://localhost:8080/cancleticket';

  public getAvailableBuses() {
    return this.http.get<Bus[]>(this.busUrl);
  }

  public findBus(idroute, date) {
    return this.http.get<Bus[]>(this.busUrl1, { params: { 'idRoute': idroute, 'date': date } })
  }

  public detail(idbus, scheduleday) {
    return this.http.get<Bus>(this.busdetail, { params: { 'id': idbus, 'scheduleday': scheduleday } })
  }

  public getSeat(idbus, scheduleday) {
    return this.http.get<BusTicket[]>(this.bookticketUrl, { params: { 'idbus': idbus, 'scheduleday': scheduleday } })
  }

  public getRoute() {
    return this.http.get<Route[]>(this.routeUrl);
  }

  public getRouteBus(){
    return this.http.get<Route[]>(this.routebusUrl);
  }

  public bookTicket(ticketbook,idticket){
    return this.http.post<TicketBook>(this.bookUrl,ticketbook,{ params:{'idticket':idticket}});
  }


  public getUsersTicket (iduser,page){
    return this.http.get<TicketBook[]>(this.usersticket, { params:{'iduser': iduser,'page':page}});
  }

  public cancleTicket(idbookticket,cancleday,idbusticket){
    return this.http.get(this.cancleticketUrl,{ params :{'idbookticket':idbookticket,'cancleday':cancleday,'idbusticket':idbusticket }});
  }

}