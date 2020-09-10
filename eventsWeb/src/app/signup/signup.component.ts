import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { Router } from '@angular/router';
import { AuthService } from 'src/services/auth.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  userForm: FormGroup = new FormGroup({
    firstName:new FormControl(),
    lastName:new FormControl(),
    mailAddress:new FormControl(),
    username:new FormControl(),
    password:new FormControl(),
    passwordVerify: new FormControl(),
    phoneNumber: new FormControl(),
    country: new FormControl()
  })

      constructor (
                    private router: Router,
                    private authService: AuthService
                  ) 
      
                    { 

                    }

  ngOnInit()        {

                    }

  signUp(user: User) : Promise<Boolean> 
                    {
                      return new Promise((resolve,reject) => {
                        this.authService.signUp(user).toPromise().then(response => {
                          resolve(true);
                        }).catch(()=> {
                          reject(false);
                        });
                      });
                    }

}
