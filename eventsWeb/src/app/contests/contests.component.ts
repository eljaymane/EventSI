import { Component, OnInit } from '@angular/core';
import { ContestService } from './services/contest/contest.service';
import { Contest } from '../model/contest.model';
import { AuthService } from 'src/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contests',
  templateUrl: './contests.component.html',
  styleUrls: ['./contests.component.scss']
})
export class ContestsComponent implements OnInit {
  public finishedLoading: boolean = false;
  public contests: Array<Contest> = new Array<Contest>();

      constructor   (
                      private contestService: ContestService,
                      private authService: AuthService,
                      private router: Router,

                    ) 
                      { 

                      }

async ngOnInit()      {
                          if(!this.authService.isLoggedIn){
                            this.router.navigate(['/login']);
                          } else {
                            this.finishedLoading = await this.getAllContests();
                          }
                         
                      }
                
getAllContests() : Promise<boolean> 
                       
                      { 
                          return new Promise( (resolve,reject) => {
                              this.contestService.getContests().toPromise().then(response => {
                              this.contests = response as Contest[];
                              }).finally(() => {
                                
                                resolve(true);
                              }).catch(() => {
                                reject(false);
                              });
                          });
                      }

  



}
