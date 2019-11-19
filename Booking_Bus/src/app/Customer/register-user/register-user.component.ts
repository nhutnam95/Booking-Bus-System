import { Component, OnInit } from '@angular/core';
import {Users} from '../../shared/users';
import {UsersService} from '../../service/users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {
  user: Users = new Users();
  constructor(
    private router:Router,
    private userService: UsersService,
  ) { }

  ngOnInit() {
     
  }

  createUser(): void {

    console.log(this.user)
    this.user.role = { idrole: 1, nameRole: 'Customer'}
    this.userService.regisUser(this.user).subscribe(
      (data) => {
        console.log(data)
      }
    )
  }
}
