import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UsersComponent } from './users/users.component';
import { BusComponent } from './Customer/bus/bus.component';
import { FindbusComponent } from './Customer/findbus/findbus.component'
import { BusdetailComponent } from './Customer/busdetail/busdetail.component'
import { RegisterUserComponent } from './Customer/register-user/register-user.component';
import { BookticketComponent } from './Customer/bookticket/bookticket.component'
import { LoginCustomerComponent } from './Customer/login-customer/login-customer.component';
import { UserbookticketComponent } from './Customer/userbookticket/userbookticket.component';

import { LayoutComponent } from './ticket-seller/layout/layout.component';
import { LoginComponent } from './ticket-seller/login/login.component';
import { AuthGuard } from './ticket-seller/guard/auth.guard';

import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { AdminRegisterComponent } from './admin/admin-register/admin-register.component';
import { AdminHomeComponent } from './admin/admin-list/admin-home.component';
import { AdminDetailComponent } from './admin/admin-update/admin-detail.component';
//import { BusNowComponent } from './Customer/bus-now/bus-now.component';

const routes: Routes = [
  { path: '', component: FindbusComponent },
  { path: 'users', component: UsersComponent },
  { path: 'index', component: BusComponent },
  { path:'detail/:id/:date', component: BusdetailComponent},
  { path:'register', component: RegisterUserComponent},
  { path:'book/:idbus/:schedule', component:BookticketComponent },
  { path:'ticket/:iduser/:page',component:UserbookticketComponent},
  //{ path:'bus/:idroute/:date',component:BusNowComponent},
 


  //Ticket Seller

  { path: 'ticket-seller/login', component: LoginComponent },

  {
    path: 'ticket-seller',
    component: LayoutComponent,
    canActivate: [AuthGuard],
    children: [
      { path: '', loadChildren: './ticket-seller/layout/layout.module#LayoutModule'}
    ]
  },


  //Admin

  { path: 'admin/list', component: AdminHomeComponent },
  { path: 'admin/login', component: AdminLoginComponent },
  { path: 'admin/register', component: AdminRegisterComponent },
  { path: 'admin/detail/:id', component: AdminDetailComponent },
]


@NgModule({
  imports: [
    RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
