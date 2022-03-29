import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginComponent } from './layout/access/login/login.component';
import { RegisterComponent } from './layout/access/register/register.component';
import { DashboardComponent } from './layout/dashboard/dashboard.component';
import { MainComponent } from './layout/main/main.component';
import { UsersComponent } from './layout/users/users.component';
import { AddUserComponent } from './layout/add-user/add-user.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    MainComponent,
    UsersComponent,
    AddUserComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
