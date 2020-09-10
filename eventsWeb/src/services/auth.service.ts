import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user.model';
import jwt_decode from "jwt-decode";
import { Router } from '@angular/router';
import { exit } from 'process';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isLoggedIn: boolean = false;
  token;
  decodedToken;
  username;
  private authUrl = "http://localhost:10002"

  constructor   (
                  private http: HttpClient,
                  private router: Router
                ) 
  
                  { 

                  }

  logout        ()
                  {
                    this.isLoggedIn = false;
                    this.redirectLogout();
                  }
  
  signUp(user: User): Observable<User>
                  {
                      return this.http.post<User>('/user',user);
                  }

  authenticate(username:string, password)  
                  {
                      this.token = "";
                      var body = {
                        username : username,
                        password: password
                                 }
                      this.http.post<any>(this.authUrl + '/authenticate',body)
                      .toPromise()
                      .then(response => {
                            this.setToken(response.token as string);
                            console.log(response.token);
                                         })
  }

  private setToken(token:string) {
    this.token = token;
    if(token=""){

    } else {
    console.log(this.token);
    //this.decodedToken = jwt_decode(token);
    //this.username = this.decodedToken['sub'];
    this.isLoggedIn = true;
    this.redirectLogin();
    }
    
  }

  private redirectLogin(){
    this.router.navigate(['/contests']);
  }

  private redirectLogout(){
    this.router.navigate(['/login']);
  }


  public getToken(){
    return this.token;
  }
}
