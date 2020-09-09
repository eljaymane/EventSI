import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Contest } from 'src/app/model/contest.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContestService {
private baseUrl = "http://localhost:10001";

      constructor (
                    private http: HttpClient
                  ) 
                  { 
                  }

      getContests() : Observable<Contest[]>
                  {
                    return this.http.get<Contest[]>(this.baseUrl + "/contests");
                  }
                            }
