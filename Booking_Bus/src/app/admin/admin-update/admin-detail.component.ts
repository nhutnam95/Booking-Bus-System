import { Component, OnInit, Input } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { AdminService } from '../../service/admin.service';
import { Users } from '../../shared/users';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-admin-detail',
  templateUrl: './admin-detail.component.html',
  styleUrls: ['./admin-detail.component.css']
})
export class AdminDetailComponent implements OnInit {

  id : number;
  user: Users;
  form: FormGroup;

  constructor(
    private activatedRoute: ActivatedRoute,
    private adminService: AdminService,
    private router:Router,
    private fb: FormBuilder ) { }

  ngOnInit() {
    this.getUser();
  }

  public getUser(): void{
    this.id = +this.activatedRoute.snapshot.params['id'];
    this.adminService.getUser(this.id).subscribe(user =>{
      this.user = user;
    })
  }

  public updateUser(): void{
    this.adminService.updateUser(this.user).subscribe(user => {
        this.user = user;
        this.router.navigate(['/admin/list']);
      })
  }

  public cancel(){
    this.router.navigate(['/admin/list']);
  }
}
