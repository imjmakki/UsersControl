import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginComponent } from './layout/access/login/login.component';
import { RegisterComponent } from './layout/access/register/register.component';
import { DashboardComponent } from './layout/dashboard/dashboard.component';
import { MainComponent } from './layout/main/main.component';
import { UsersComponent } from './layout/users/users.component';
import { AddUserComponent } from './layout/add-user/add-user.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './layout/navbar/navbar.component';
import { TableComponent } from './layout/table/table.component';
//Modules
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import {AuthenticationService} from "./service/authentication.service";
import {UserService} from "./service/user.service";
import {AuthInterceptor} from "./interceptor/auth.interceptor";
import {AuthenticationGuard} from "./guard/authentication.guard";
import {NotificationModule} from "./module/notification.module";
import {NotificationService} from "./service/notifiction.service";
//Material

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    MainComponent,
    UsersComponent,
    AddUserComponent,
    NavbarComponent,
    TableComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    NotificationModule
  ],
  providers: [NotificationService, AuthenticationGuard ,AuthenticationService, UserService,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
