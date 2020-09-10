import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Contest } from 'src/app/model/contest.model';
import { Observable } from 'rxjs';
import { AuthService } from 'src/services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class ContestService {
private baseUrl = "http://localhost:10001";
private token;

      constructor (
                    private http: HttpClient,
                    private authService: AuthService
                  ) 
                  { 
                  }

      getContests() : Observable<any>
                  {
                    this.token = this.authService.token;
                    console.log(this.token)
                    let headers = new HttpHeaders();
                    
                    headers.set("Authorization","Bearer "+ this.token);
                    console.log(headers)
                    return this.http.get<Contest[]>(this.baseUrl + "/contests",{headers: headers});
                  }
                            }
