import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { Observable } from 'rxjs';

import { BusTicket } from '../../shared/bus-ticket';
import { Status } from '../../shared/status';

import { BusTicketService } from '../../service/bus-ticket.service';

@Component({
  selector: 'bus-ticket',
  templateUrl: './bus-ticket.component.html',
  styleUrls: ['./bus-ticket.component.css']
})
export class BusTicketComponent implements OnInit {

  @Input() ticket: BusTicket;

  tickets: Array<any>;

  idBus: number;
  date: string;
  page: number = 0;
  pages: Array<any>;
  status: Status;

  isInitial: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private busTicketService: BusTicketService
  ) { }

  ngOnInit() {
    this.getTickets();
  }

  setPage(i, event: any) {
    event.preventDefault();
    this.page = i;
    this.getTickets();
  }

  getTickets(): void {
    this.idBus = +this.route.snapshot.queryParams['idbus'];
    this.date = this.route.snapshot.queryParams['scheduleday'];

    this.busTicketService.findTicket(this.idBus, this.date, this.page).subscribe(
      (data) => {
        console.log(data);
        this.tickets = data['content'];
        this.pages = new Array(data['totalPages']);
        this.status = data['content[status]'];
      }
    );
  }

  goBack(): void {
    this.location.back();
  }

}
