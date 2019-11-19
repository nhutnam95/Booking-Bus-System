import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Users } from '../shared/users';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  user: Users;
  emailArr: String[] = [];

  constructor(
    private http: HttpClient
  ) {
    console.log("asdasdlkashdiu")
    this.http.get<Users[]>(this.usersUrl).subscribe(
      (user) => {
        this.emailArr = user.map(user => user.email);
        console.log(this.emailArr)
      }
    );

    if (localStorage.getItem('user') != null) {
      this.user = JSON.parse(localStorage.getItem('user'));
    }

  }

  private usersUrl = 'http://localhost:8080/users';
  private findByEmail = 'http://localhost:8080/findbyEmail';
  private loginTicketSellerUrl = 'http://localhost:8080/login-seller';
  private userRegisterUrl = 'http://localhost:8080/save';
  private loginCustomerUrl = 'http://localhost:8080/loginCustomer';

  public getUsers() {
    return this.http.get<Users[]>(this.usersUrl);
  }

  public regisUser(user) {
    return this.http.post<Users>(this.userRegisterUrl, user);
  }

  public loginCustomer(email, password) {
    return this.http.get(this.loginCustomerUrl,
      { params: { 'email': email, 'password': password }, responseType: "text" },
    )
  }

  public getCustomer(email) {
    return this.http.get<Users>(this.findByEmail,
      { params: { 'email': email }, headers: { 'authorization': localStorage.getItem('token') } },
    )
  }

  loginTicketSeller(email: string, password: string) {
    return this.http.get(this.loginTicketSellerUrl, { params: { 'email': email, 'password': password } });
  }

}
