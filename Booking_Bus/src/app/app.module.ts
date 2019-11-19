import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { BusComponent } from './Customer/bus/bus.component';
import { FindbusComponent } from './Customer/findbus/findbus.component';
import { BusdetailComponent } from './Customer/busdetail/busdetail.component';
import { RegisterUserComponent } from './Customer/register-user/register-user.component';
import {BookticketComponent} from './Customer/bookticket/bookticket.component';
import { LoginCustomerComponent } from './Customer/login-customer/login-customer.component';
import { HeaderComponent } from './Customer/header/header.component';

import { ComponentsModule } from './ticket-seller/components/components.module';
import { LayoutComponent } from './ticket-seller/layout/layout.component';
import { LoginComponent } from './ticket-seller/login/login.component';
import { AuthGuard } from './ticket-seller/guard/auth.guard';

import { AdminHeaderComponent } from './admin/admin-header/admin-header.component';
import { AdminHomeComponent } from './admin/admin-list/admin-home.component';
import { AdminDetailComponent } from './admin/admin-update/admin-detail.component';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { AdminRegisterComponent } from './admin/admin-register/admin-register.component';
import { UserbookticketComponent } from './Customer/userbookticket/userbookticket.component';
import { AdminChangePasswordComponent } from './admin/admin-change-password/admin-change-password.component';
//import { BusNowComponent } from './Customer/bus-now/bus-now.component';
//import { AlertsModule } from 'angular-alert-module';

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    BusComponent,
    FindbusComponent,
    BusdetailComponent,
    RegisterUserComponent,
    BookticketComponent,
    LoginCustomerComponent,
    HeaderComponent,

    LayoutComponent,
    LoginComponent,
    
    AdminHeaderComponent,
    AdminHomeComponent,
    AdminDetailComponent,
    AdminLoginComponent,
    AdminRegisterComponent,
    UserbookticketComponent,
    AdminChangePasswordComponent,
    //BusNowComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    RouterModule,
    AppRoutingModule,
    HttpClientModule, 
    FormsModule,
    ComponentsModule,
    ReactiveFormsModule,
    //AlertsModule.forRoot()
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
