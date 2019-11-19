import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators, AbstractControl } from '@angular/forms';
import { AdminService } from '../../service/admin.service';

@Component({
  selector: 'app-admin-change-password',
  templateUrl: './admin-change-password.component.html',
  styleUrls: ['./admin-change-password.component.css']
})
export class AdminChangePasswordComponent implements OnInit {
  changePasswordForm:FormGroup;

  constructor(fb: FormBuilder) {
    this.changePasswordForm = fb.group({
      'old_password': [null, Validators.required],
      'new_password': [null, Validators.required],
      'confirm_new_password': [null, [Validators.required, this.passwordMatch]] 
    });
   }

  ngOnInit() {
  }
  passwordMatch(control: AbstractControl){
    let paswd = control.root.get('new_password');
    if(paswd && control.value != paswd.value){
     return {
         passwordMatch: false
     };   
    }
    return null;
  }
  changePassword(value){
    if(this.changePasswordForm.valid){
        console.log("Change password form valid");
    }
}

}
