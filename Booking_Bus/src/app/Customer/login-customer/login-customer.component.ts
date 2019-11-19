import { Component, OnInit } from '@angular/core';
import {UsersService} from '../../service/users.service';
import { Router } from '@angular/router';
import {formatDate } from '@angular/common';

@Component({
  selector: 'app-login-customer',
  templateUrl: './login-customer.component.html',
  styleUrls: ['./login-customer.component.css']
})
export class LoginCustomerComponent implements OnInit {
  email:String;
  password:String;
  today= new Date();
  jstoday : number;
  tomorrow = new Date();
  nextday = '';
  testngay =5
  testtest ='';
  constructor(
    private router:Router,
    private userService: UsersService,
  ) { }

  ngOnInit() {
    console.log(this.today)
    this.jstoday = +formatDate(this.today, 'h', 'en-US', '+0700');
    console.log(this.jstoday)
    this.tomorrow = new Date(this.today.setDate(this.today.getDate()+1));
    this.nextday = formatDate(this.tomorrow, 'yyyy-MM-dd', 'en-US', '+0530');
    console.log(this.nextday);
   
    console.log(this.testngay)

    if(+this.jstoday > +this.testngay){
      console.log(this.testngay)
    }

  }

//  loginCustomer():void{
//    this.userService.loginCustomer(this.email,this.password).subscribe(
//     (data) => {
//       console.log(data)
//       // this.userService.user=data;
    
      
//     }
//    )

//    }
 }


