
import { AbstractControl, AsyncValidatorFn, ValidationErrors } from '@angular/forms'
//import { AuthService } from '../../admin/admin-login/auth.service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { UsersService } from '../../service/users.service';


export function comparePassword(c: AbstractControl) {
  const v = c.value;
  return (v.password === v.confirmPassword) ? null : {
    passwordnotmatch: true
  };
}


export function forbiddenUsername(users, usersService: UsersService) {
  return (c: AbstractControl) => {
    return (usersService.emailArr.includes(c.value)) ? {
      invalidusername: true
    } : null;
  };
}

// export  function  existUsername(userService:  AuthService):  AsyncValidatorFn  {
//   return  (control:  AbstractControl):  Promise<ValidationErrors  |  null>  |  Observable<ValidationErrors  |  null>  =>  {

//     return  userService.validateUsername(control.value).pipe(
//       map(isTaken  =>  (isTaken  ?  {  conflictUsername:  true  }  :  null)),
//     );
//   };
// } 