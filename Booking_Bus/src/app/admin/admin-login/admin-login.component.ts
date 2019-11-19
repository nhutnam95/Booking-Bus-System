import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../../service/admin.service';
import { FormBuilder, FormGroup, Validator, FormControl, Validators } from '@angular/forms';
import { Users } from '../../shared/users';
import { comparePassword, forbiddenUsername } from '../../Customer/header/validators';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  email: String;
  password: String;
  form: FormGroup;
  users: Users = new Users();
  emailArr: String[] = []
  user: Users[];

  constructor(private router: Router, public adminService: AdminService, private fb: FormBuilder) { }

  ngOnInit() {
    
  }

  loginAdmin(): void{
    this.adminService.loginAdmin(this.email, this.password).subscribe(
      (data) => {
        console.log(data)
        localStorage.setItem('token', data);
        this.adminService.getUserAdmin(this.email).subscribe(
          (data) => {
            console.log(data)
            this.adminService.user = data;
            localStorage.setItem('user', JSON.stringify(data));
            alert("Login susscess");
            this.router.navigate(['/admin/list']);
          }
        )
      }
    )
  }

  logout() {
    this.adminService.user = null;
    localStorage.clear();
  }

}
