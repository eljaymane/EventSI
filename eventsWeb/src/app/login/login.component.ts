import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/services/auth.service';
import { User } from '../model/user.model';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  userForm: FormGroup = new FormGroup({
    username:new FormControl(),
    password:new FormControl()
  })
      constructor (
                    private router: Router,
                    private authService: AuthService
                  ) 
                    { 

                    }

      ngOnInit()    {
        var fb = new FormBuilder();
        this.userForm = fb.group({
          username: [
              "",
              [Validators.required, Validators.maxLength(64)],
          ],
          password: [
              "",
              [Validators.required],
          ],
         
         
          
      });
    // if(this.authService.isLoggedIn){
    //   this.router.navigate(['/events']);
    // }
                    }

  onSubmit()  {  
    const userLogin = this.userForm.value;
    this.login(userLogin.username,userLogin.password);
                    }

  login(username:string,password:string)
                    {
                      this.authService.authenticate(username,password);
                    }

  

}
