import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {RouterModule, Routes} from "@angular/router";
import { AppComponent } from './app.component';
import { EventsComponent } from './events/events.component';
import { LoginComponent } from './login/login.component';
import { ContestsComponent } from './contests/contests.component';
import { NavigationComponent } from './navigation/navigation.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import {MatIconModule} from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule } from '@angular/material/list';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatButtonModule} from '@angular/material/button';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatCardModule } from '@angular/material/card';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { SignupComponent } from './signup/signup.component';
import { AuthInterceptor } from 'src/services/auth.interceptor';
const appRoutes: Routes = [
  { path: '', component: LoginComponent, data: { title: 'Sign in' } },
  { path: 'events', component: EventsComponent, data: { title: 'Events' } },
  { path: 'contests', component: ContestsComponent, data: { title: 'Contests' } },
  { path: 'login', component: LoginComponent, data: { title: 'Login' } },
  { path: 'signup', component: SignupComponent, data: { title: 'SignUp' } }
];
@NgModule({
  declarations: [
    AppComponent,
    EventsComponent,
    LoginComponent,
    ContestsComponent,
    NavigationComponent,
    SignupComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatSliderModule,
    MatIconModule,
    MatToolbarModule,
    MatListModule,
    MatSidenavModule,
    MatButtonModule,
    MatProgressSpinnerModule,
    MatCardModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [
    {
      provide : HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi   : true,
    }
  ],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})
export class AppModule { }

