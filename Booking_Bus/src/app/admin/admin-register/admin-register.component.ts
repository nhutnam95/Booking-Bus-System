import { Component, OnInit } from '@angular/core';
import { Users } from '../../shared/users';
import { AdminService } from '../../service/admin.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-admin-register',
  templateUrl: './admin-register.component.html',
  styleUrls: ['./admin-register.component.css']
})
export class AdminRegisterComponent implements OnInit {

  form: FormGroup;
  user: Users = new Users();
  emailArr: String[] = []
  constructor(
    private router: Router,
    private adminService: AdminService,
    private fb: FormBuilder
  ) { }



  ngOnInit() {

  }

  public createUser(): void{
    this.user.role = { idrole: 2, nameRole: 'Ticket Seller'}
    this.adminService.registerUser(this.user)
    .subscribe(data => { 
      alert("Register user succsess");
      this.router.navigate(['/admin/list']);
     });
  };

  public cancel(){
    this.router.navigate(['/admin/list']);
  }
}
