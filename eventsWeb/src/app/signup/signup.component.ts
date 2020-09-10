import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { Router } from '@angular/router';
import { AuthService } from 'src/services/auth.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Rank } from '../model/rank.model';

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

  async onSubmit()        {
                    var userValues = this.userForm.value;
                      var user = new User(0,userValues.username, userValues.password, userValues.mailAddress,userValues.country
                                  ,userValues.firstName,userValues.lastName
                                  ,userValues.phoneNumber,new Rank(1,"Amateur",100),null);
                                  console.log(user)
                      if(await this.authService.signUp(user)){
                        this.authService.logout();
                      }

                    }

}
