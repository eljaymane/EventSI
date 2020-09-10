import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/services/auth.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {
  isLogged;

  constructor (
                private authService: AuthService
              ) 
                { 

                }

  ngOnInit() {
    this.isLogged = this.authService.isLoggedIn;
  }

  logout(){
    this.authService.logout();
  }

}
