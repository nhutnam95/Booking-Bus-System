import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../service/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.css']
})
export class AdminHeaderComponent implements OnInit {

  constructor(private router: Router, public adminService: AdminService) { }

  ngOnInit() {
    console.log(this.adminService.user.name)
  }

  logout() {
    this.adminService.user = null;
    localStorage.clear();
    this.router.navigate(['/admin/login']);
  }

}
