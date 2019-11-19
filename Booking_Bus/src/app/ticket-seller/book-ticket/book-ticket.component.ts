import { Component, OnInit } from '@angular/core';
import { formatDate } from '@angular/common';

import { TicketBook } from '../../shared/book-ticket';
import { StatusBook } from '../../shared/book-status';
import { BookTicketService } from '../../service/book-ticket.service';
import { BusService } from '../../service/bus.service';
import { Bus } from '../../shared/bus';
import { Router } from '@angular/router';
import {Route} from '../../shared/route';
@Component({
  selector: 'book-ticket',
  templateUrl: './book-ticket.component.html',
  styleUrls: ['./book-ticket.component.css']
})
export class BookTicketComponent implements OnInit {

  bookedTicket: TicketBook;
  status: StatusBook;
  bookedTickets: TicketBook[];
  pages: Array<any>;
  page: number = 0;
  today = new Date();
  jstoday = '';
  route:Route[];

  buses: Bus[];

  idbus: number;
  scheduleday: string;

  constructor(
    private bookTicketService: BookTicketService,
    private busService: BusService,
    private allroute : BusService,
  ) { }

  ngOnInit() {
    this.getBookedTickets();
	this.getAvailableBuses();
    this.allroute.getRoute().subscribe(route=>{
      this.route =route
      console.log(route)
    })
  }

  setPage(i, event: any) {
    event.preventDefault();
    this.page = i;
    this.getBookedTickets();
  }

  getBookedTickets(): void {
    this.bookTicketService.getBookedTickets(this.page).subscribe(
      (data) => {
        console.log(data);
        this.bookedTickets = data['content'];
        this.pages = new Array(data['totalPages']);
        this.status = data['content[statusbook]'];
      },
      (error) => {
        console.log(error);
      }
    );
  }

  cancleTicket(idbookticket, idticket) {
    this.jstoday = formatDate(this.today, 'dd-MM-yyyy', 'en-US', '+0530');
    console.log(this.jstoday)

    this.busService.cancleTicket(+idbookticket, this.jstoday, idticket).subscribe(
      (data) => {
        console.log(data)
        window.location.reload();
      }

    )
  }

	searchBookedTicket() {
    this.bookTicketService.searchBookedTicket(this.idbus, this.scheduleday, this.page).subscribe(
      (ticket) => {
        this.bookedTickets = ticket['content'];
        this.pages = ticket['totalPage'];
        console.log(ticket);
      }
    );
  }

  getAvailableBuses(): void {
    this.busService.getAvailableBuses().subscribe(
      (bus) => {
        console.log(bus);
        this.buses = bus;
      }
    );
  }  
  filter(t,r){
   if(t!='' && r =='') {
   this.getticketbystatus(t)
   }
   if(t=="" && r!=''){
    this.getticketbyroute(r)
   }
   if(t!='' && r!=''){
     this.getticketbyStatusandRoute(r,t);
   }
      
  }



  getticketbystatus(t){
    this.bookTicketService.getStatusfilter(t).subscribe(
      (data)=>{
        console.log(data)
        this.bookedTickets = data;
        
      }
    )
  }

  getticketbyroute(r){
    this.bookTicketService.getRoutefilter(r).subscribe(
      (data)=>{
        console.log(data);
        this.bookedTickets =data;
      }
    )
  }
  getticketbyStatusandRoute(r,t){
    this.bookTicketService.getRouteandStatusfilter(r,t).subscribe(
      (data)=>{
        console.log(data);
        this.bookedTickets =data;

      }
    )

  }

  cons(a){
    console.log(a)
  }

}
