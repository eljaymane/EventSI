import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';


import { AuthService } from './auth.service';
import { Observable } from 'rxjs';

@Injectable()


export class AuthInterceptor implements HttpInterceptor {
    constructor(private authService: AuthService) {
    
    }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if(this.authService.isLoggedIn){
        req = req.clone({
            setHeaders: {
              'Content-Type' : 'application/json; charset=utf-8',
              'Accept'       : 'application/json',
                  'Authorization': `Bearer ${this.authService.token}`,
                  //#endregion
              },
              
            })
    }
    
      return next.handle(req);
    }
    
}