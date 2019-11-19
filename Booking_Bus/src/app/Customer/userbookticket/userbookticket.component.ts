import { Component, OnInit } from '@angular/core';
import {TicketBook} from '../../shared/book-ticket';
import {BusService} from '../../service/bus.service';
import { Router, ActivatedRoute,ParamMap } from '@angular/router';
import {formatDate } from '@angular/common';

@Component({
  selector: 'app-userbookticket',
  templateUrl: './userbookticket.component.html',
  styleUrls: ['./userbookticket.component.css']
})
export class UserbookticketComponent implements OnInit {
  ticketuser: TicketBook [];
  iduser=0;
  idbookticket:number;
  today= new Date();
  jstoday = '';
  page: number=0;
  pages: Array<any>;
  constructor(
    private busService:BusService,
    private activatedRoute: ActivatedRoute,
    private router:Router
  ){}


  ngOnInit() {
    this.getUserTicket();
  }


  setPage(i, event: any) {
    event.preventDefault();
    this.page = i;
    this.getUserTicket();
    this.router.navigateByUrl("ticket/1"+"/"+this.page)

  }

  
  cancleTicket(idbookticket, index,idticket)
  {
    this.jstoday = formatDate(this.today, 'dd-MM-yyyy HH:MM:ss', 'en-US', '+0700');
    console.log(this.jstoday)
    this.ticketuser.splice(index, 1)
     this.busService.cancleTicket(+idbookticket,this.jstoday,+idticket).subscribe(
       (data) => {
         console.log(data)
       }
       
     )
  }

  getUserTicket():void {
    this.iduser = +this.activatedRoute.snapshot.params['iduser'];
    this.jstoday = formatDate(this.today, 'dd-MM-yyyy', 'en-US', '+0530');
    console.log(this.jstoday)
    // console.log(this.iduser)
    this.busService.getUsersTicket(this.iduser,this.page).subscribe(
      ticketuser=>{
        this.ticketuser=ticketuser['content'];
       this.pages = new Array(ticketuser['totalPages']);
       
      }
    )
  }

}
