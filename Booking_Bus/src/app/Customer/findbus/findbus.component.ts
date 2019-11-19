import { Component, OnInit } from '@angular/core';
import { Bus } from '../../shared/bus';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { BusService } from '../../service/bus.service';
import {Route} from '../../shared/route';
import {formatDate } from '@angular/common';

@Component({
  selector: 'app-findbus',
  templateUrl: './findbus.component.html',
  styleUrls: ['./findbus.component.css']
})
export class FindbusComponent implements OnInit {
  idroute: number=1;
  // idArr = [{id: 1, name: 'asdas'}, {id: 2, name: 'adasdsad135'}];
  date: string;
  bus: Bus[];
  route:Route[];
  routeBus:Route[] = [];
  count:number;
  today= new Date();
  jstoday = '';
  tomorrow = new Date();
  nextday = '';
  nowday ='';
  nowtime:number;
  
  findBusObservable: Observable<Bus[]>;
  constructor(
    private router: Router,
    private findBus: BusService,
    private allroute : BusService,
    private routebus: BusService,
  ) { }

  ngOnInit() {
    this.allroute.getRoute().subscribe(route=>{
      this.route =route
    })

    this.routebus.getRouteBus().subscribe(routeBus => {
      for (let i = 0; i < routeBus.length; i++) {
        const newrouteBus = routeBus[i][0];
        newrouteBus['count'] = routeBus[i][1]
        

        this.routeBus.push(newrouteBus);
      
        
        console.log(this.routeBus)
      }
     
    })

    console.log(this.today)
    this.jstoday = formatDate(this.today, 'EEEE, MMMM d, y', 'en-US', '+0700');
    console.log(this.jstoday)
    this.nowtime =+formatDate(this.today,'HH','en-US','+0700')
    console.log(this.nowtime);
    this.nowday = formatDate(this.today,'yyyy-MM-dd','en-US','+0700')
    this.tomorrow = new Date(this.today.setDate(this.today.getDate()+1));
    this.nextday = formatDate(this.tomorrow, 'yyyy-MM-dd', 'en-US', '+0530');
    console.log(this.nextday);
    

  
     
  }

  submit() {
    // this.findBusObservable = this.findBus.findBus(this.idroute, this.date);
    this.router.navigate(["/index"], { queryParams: { id: this.idroute, date: this.date} });
  }

  changeIdRoute(value) {
    this.idroute = value
    console.log(this.date);
  }

  selectOption(id: number) {
    //getted from event
    console.log(id);
    
  }
  
}
