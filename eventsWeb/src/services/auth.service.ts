import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user.model';
import jwt_decode from "jwt-decode";
import { Router } from '@angular/router';
import { exit } from 'process';
import { renderFlagCheckIfStmt } from '@angular/compiler/src/render3/view/template';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isLoggedIn: boolean = false;
  token;
  decodedToken;
  username;
  private authUrl = "http://localhost:10002";
  private baseUrl = "http://localhost:10001"

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
  
  signUp(user: User): Promise<Boolean>
                  {
                    return new Promise(async (resolve,reject) => {
                      await this.register(user.username,user.password,user.email).toPromise().then(() => {
                        this.http.post<User>(this.baseUrl + '/users',user);
                      }).finally(() => {
                        resolve(true);
                      })
                      reject(false);
                    })
                    
                  }
  register(username:string,password:string,email:string){
    var body = {
      username: username,
      password: password,
      email: email
    }
    return this.http.post<any>(this.authUrl + '/register',body);
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
