import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../service/admin.service';
import { Role } from '../../shared/role';
import { Router,ActivatedRoute } from '@angular/router';
import { Users } from '../../shared/users';
import { Location } from '@angular/common';
import { SelectorMatcher } from '@angular/compiler';
import { FormBuilder, FormGroup, Validator, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  public page: number = 0;
  public users: Array<any>;
  public pages: Array<any>;
  public role: Role;
  find:String;
  form: FormGroup;

  id: number;
  user: Users;

  constructor(
    private adminService: AdminService,
    private activatedRoute: ActivatedRoute,
    private router:Router,
    private location: Location,
    private fb: FormBuilder
  ) { }

  ngOnInit() {
    this.getAllUser();
  }

  setPage(i, event: any) {
    event.preventDefault();
    this.page = i;
    this.getAllUser();
  }

  getAllUser(): void {
    this.adminService.getAllUser(this.page).subscribe(
      (data) => {
        console.log(data);
        this.users = data['content'];
        this.pages = new Array(data['totalPages']);
        this.role = data['content[role]']
      },
      (error) => {
        console.log(error);
      }
    );
  }

  deleteUser(id){
      confirm("Do you want delete user?");
      this.adminService.deleteUser(id).subscribe(data => {
        console.log(data);
        alert("Delete susscess!!!");
    })
  }

  search(option, s){
    console.log(s);
    if(option == 1){
      this.findByNameContaining(s);
    }
    if(option == 2){
      this.findByName(s);
    }
    if(option == 3){
      this.findByRole(s);
    }if(option == 4){
      this.findByEmail(s);
    }
  }

  filter(option){
    if(option == 1){
      this.findByRole("admin")
    }
    if(option == 2){
      this.findByRole("customer")
    }
    if(option == 3){
      this.findByRole("ticket seller")
    }
  }

  findByNameContaining(s){
    this.adminService.findByNameContaining(s).subscribe(
      (data)=>{
        console.log(data);
        this.users =data;
        console.log(this.users);
      }
    )
  }

  findByName(s){
    this.adminService.findByName(s).subscribe(
      (data)=>{
        console.log(data);
        this.users =data;
        console.log(this.users);
      }
    )
  }

  findByRole(s){
    this.adminService.findByRole(s).subscribe(
      (data)=>{
        console.log(data);
        this.users =data;
        console.log(this.users);
      }
    )
  }

  findByEmail(s){
    this.adminService.findByEmail(s).subscribe(
      (data)=>{
        console.log(data);
        this.users =data;
        console.log(this.users);
      }
    )
  }
}

