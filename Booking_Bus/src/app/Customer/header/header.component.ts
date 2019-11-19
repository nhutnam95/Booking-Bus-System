import { Component, OnInit } from '@angular/core';
import { UsersService } from '../../service/users.service';
import { FormBuilder, FormGroup, Validator, FormControl, Validators } from '@angular/forms';
import { comparePassword, forbiddenUsername } from './validators';
import { Users } from '../../shared/users';




@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  form: FormGroup;
  users: Users = new Users();
  emaillogin: String;
  passwordlogin: String;
  emailArr: String[] = []
  user: Users[];
  constructor(
    private fb: FormBuilder,
    public userService: UsersService,
  ) { }

  account_validation_messages = {
    'name': [
      { type: 'required', message: 'Username is required' },
      { type: 'minlength', message: 'Username must be at least 5 characters long' },
      { type: 'maxlength', message: 'Username cannot be more than 25 characters long' },

    ],
    'email': [
      { type: 'required', message: 'Email is required' },
      { type: 'pattern', message: 'Enter a valid email' }
    ],

    'password': [
      { type: 'required', message: 'Password is required' },
      { type: 'minlength', message: 'Password must be at least 5 characters long' },
      { type: 'pattern', message: 'Your password must contain at least one uppercase, one lowercase, and one number' }
    ],
  }

  ngOnInit() {

    this.userService.getUsers().subscribe(user => {
      this.user = user
    });




    this.form = this.fb.group({
      name: new FormControl('', Validators.compose([
        Validators.maxLength(20),
        Validators.minLength(5),
      ])),


      email: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$'),
        forbiddenUsername(this.emailArr, this.userService)
      ])),

      pw: this.fb.group({
        password: new FormControl('', Validators.compose([
          Validators.minLength(5),
          Validators.required,
          Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]+$')
        ])),
        confirmPassword: new FormControl('', Validators.required)
      }, {
          validator: comparePassword
        })


    })




  }



  logout() {
    this.userService.user = null;
    localStorage.clear();
  }



  //SIGN UP
  createUser(): void {
    // console.log(this.form.value);
    this.users.name = this.form.value['name'];
    this.users.email = this.form.value['email'];
    this.users.password = this.form.value['pw']["password"];
    this.users.role = { idrole: 1, nameRole: 'Customer' };
    console.log(this.users);
    this.userService.regisUser(this.users).subscribe(
      (data) => {
        console.log(data)
        alert("Create Account Successful !!!");
      }
    )
  }


  //SIGN IN 
  loginCustomer(): void {
    this.userService.loginCustomer(this.emaillogin, this.passwordlogin).subscribe(
      (data) => {
        console.log(data)
        // this.userService.user = data;
        // alert("Login Successful !!!");
        localStorage.setItem('token', data);

        this.userService.getCustomer(this.emaillogin).subscribe(
          (data) => {
            console.log(data)
            this.userService.user = data;
            localStorage.setItem('user', JSON.stringify(data));
            alert("Login Successful !!!");
          }
        )

      }
    )

  }


}
