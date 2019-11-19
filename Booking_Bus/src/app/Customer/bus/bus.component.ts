import { Component, OnInit } from '@angular/core';
import { Bus } from '../../shared/bus';
import { Router, ActivatedRoute } from '@angular/router';
import { BusService } from '../../service/bus.service'

@Component({
  selector: 'app-bus',
  templateUrl: './bus.component.html',
  styleUrls: ['./bus.component.css']
})
export class BusComponent implements OnInit {
  bus: Bus[] = [];

  idRoute: number;
  date: string;
  place: string;
  count: number;
  routename: string;

  constructor(
    private router: Router,
    private busService: BusService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {

    this.idRoute = +this.activatedRoute.snapshot.queryParams['id'];
    this.date = this.activatedRoute.snapshot.queryParams['date'];
    
    this.busService.findBus(this.idRoute, this.date).subscribe(bus => {
      // this.bus = bus[0][0];
      for (let i = 0; i < bus.length; i++) {
        const newBus = bus[i][0];
        newBus['count'] = bus[i][1]
        

        this.bus.push(newBus);
        this.routename =bus[i][2];
        
        console.log(this.bus)
      }
     
    })

    

  }

}
