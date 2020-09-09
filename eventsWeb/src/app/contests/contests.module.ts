import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatCardModule } from '@angular/material/card'
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner'
import { ContestsComponent } from './contests.component';


@NgModule({
  declarations: [
                ContestsComponent
                ],
  imports: [

                MatCardModule,
                MatProgressSpinnerModule
           ],
  providers: [],
  bootstrap: []
})
export class ContestsModule { }
