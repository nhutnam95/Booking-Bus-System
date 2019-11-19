import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Users } from '../shared/users';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type' : 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  user: Users;
  emailArr: String[] = [];

  private Url = 'http://localhost:8080/admin';
  private loginAdminUrl = 'http://localhost:8080/admin/loginAdmin';
  private findByEmailUrl = 'http://localhost:8080/admin/findByEmail';
  private findByNameUrl = 'http://localhost:8080/admin/findByNameContaining';

  constructor(private http: HttpClient) {
    console.log("asdasdlkashdiu")
    this.http.get<Users[]>(`${this.Url}/getUsers`).subscribe(
      (user) => {
        this.emailArr = user.map(user => user.email);
        console.log(this.emailArr)
      }
    );

    if (localStorage.getItem('user') != null) {
        this.user = JSON.parse(localStorage.getItem('user'));
    }
   }

  public getAllUser(page: number): Observable<any> {
    return this.http.get(`${this.Url}/getUsers?page=` + page);
  }

  public getUser(id: number) {
    return this.http.get<Users>(`${this.Url}/getUser/${id}`);
  }

  public updateUser(user: Users): Observable<any> {
    return this.http.put(`${this.Url}/updateUser`, user, httpOptions);
  }

  public registerUser(user){
    return this.http.post<Users>(`${this.Url}/createUser`,user);
  }

  public deleteUser(id: number){
    return this.http.delete(`${this.Url}/deleteUser/${id}`);
  }

  public loginAdmin(email,password){
    return this.http.get(`${this.Url}/loginAdmin`,{params: { 'email': email, 'password': password },responseType:"text"},)
  }

  public getUserAdmin(email) {
    return this.http.get<Users>(`${this.Url}/findByEmail`,
      { params: { 'email': email }, headers: { 'authorization': localStorage.getItem('token') } },
    )
  }

  ////////////////////
  public findByNameContaining(name){
    return this.http.get<Users[]>(`${this.Url}/findByNameContaining`,{params: {'name': name}});
  }

  public findByName(name){
    return this.http.get<Users[]>(`${this.Url}/findByName`,{params: {'name': name}});
  }

  public findByRole(name){
    return this.http.get<Users[]>(`${this.Url}/findUserByRole`,{params: {'name': name}});
  }

  public findByEmail(email){
    return this.http.get<Users[]>(`${this.Url}/findByEmail`,{params: {'email': email}});
  }
}
