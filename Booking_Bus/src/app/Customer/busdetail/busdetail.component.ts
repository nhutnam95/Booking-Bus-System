import { Component, OnInit } from '@angular/core';
import{Bus} from '../../shared/bus';
import{Router, ActivatedRoute} from '@angular/router';
import{BusService} from '../../service/bus.service';


@Component({
  selector: 'app-busdetail',
  templateUrl: './busdetail.component.html',
  styleUrls: ['./busdetail.component.css']
})
export class BusdetailComponent implements OnInit {
  idBus :number;
  scheduleday:string;
  bus:Bus;
  count: number;
  constructor(
    private router:Router,
    private busService:BusService,
    private activatedRoute: ActivatedRoute
  ) { }

  

  ngOnInit() {
    this.idBus = +this.activatedRoute.snapshot.params['id'];
    this.scheduleday = this.activatedRoute.snapshot.params['date'];

    console.log(this.idBus)
    console.log(this.scheduleday)
    this.busService.detail(this.idBus,this.scheduleday).subscribe(bus =>{
      console.log(bus);
      this.bus = bus[0][0];
      this.count = bus[0][1];
     
      
    })
  }

}
