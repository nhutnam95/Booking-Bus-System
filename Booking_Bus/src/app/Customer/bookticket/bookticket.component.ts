import { Component, OnInit } from '@angular/core';
import { BusTicket } from '../../shared/bus-ticket';
import { Router, ActivatedRoute, ChildActivationStart } from '@angular/router';
import { BusService } from '../../service/bus.service'
import { UsersService } from '../../service/users.service';
import { TicketBook } from '../../shared/book-ticket';
import { Users } from '../../shared/users';
import { StatusBook } from '../../shared/book-status';
import {formatDate } from '@angular/common';
//import { AlertsService } from 'angular-alert-module';
@Component({
  selector: 'app-bookticket',
  templateUrl: './bookticket.component.html',
  styleUrls: ['./bookticket.component.css']
})
export class BookticketComponent implements OnInit {
  busTicket: BusTicket[] = [];
  idBus: number;
  scheduleday: string;
  selectedSeat: BusTicket;
  ticketbook: TicketBook = new TicketBook();
  idstatus: number;
  today= new Date();
  jstoday = '';

  constructor(
    private busService: BusService,
    private activatedRoute: ActivatedRoute,
    public userService: UsersService,
    private router: Router,
    //private alerts: AlertsService

  ) { }

  onSelect(seat: BusTicket): void {
    if (seat.status.idstatus === 1)
      this.selectedSeat = seat;
  }
  ngOnInit() {
    this.idBus = +this.activatedRoute.snapshot.params['idbus'];
    this.scheduleday = this.activatedRoute.snapshot.params['schedule'];

    this.busService.getSeat(this.idBus, this.scheduleday).subscribe(busTicket => {
      this.busTicket = busTicket;


    }
    )

    
  }

  navigateBook() {
    this.router.navigate(['/bookticket', this.userService.user.id, this.selectedSeat.idticket]);
  }



  bookTicket() {

    this.jstoday = formatDate(this.today, 'dd-MM-yyyy HH:mm:ss', 'en-US', '+0700');

   if(this.userService.user ==null)
   alert("You have to Sign up to Book Ticket")
   else{
    this.ticketbook.users = new Users();
    this.ticketbook.ticket = new BusTicket();
    this.ticketbook.statusbook = new StatusBook();

    this.ticketbook.users.id = this.userService.user.id;
    this.ticketbook.ticket.idticket = this.selectedSeat.idticket;
    // this.ticketbook.statusbook.idstatusbook = this.idstatus;
    this.ticketbook.statusbook = { idstatusbook: 1 , statusbook : 'Booking'}
    this.ticketbook.bookday = this.jstoday
    console.log(this.ticketbook)
    this.selectedSeat.status.idstatus = 2;
    this.busService.bookTicket(this.ticketbook,this.selectedSeat.idticket).subscribe(
      (data) => {
        console.log(data)
       
        alert("Book Seat successful!!!!");
      }
    )
  }

  }



}
