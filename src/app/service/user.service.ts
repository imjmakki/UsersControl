import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpResponse} from "@angular/common/http";
import { environment } from "../../environments/environment";
import {Observable} from "rxjs";
import {User} from "../model/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private host = environment.apiUrl;

  constructor(private http: HttpClient) { }

  public getUsers(): Observable<User[] | HttpErrorResponse> {
    return this.http.get<User[]>(`${this.host}/user/all`);
  }

  public addUser(formData: FormData): Observable<User | HttpErrorResponse> {
    return this.http.post<User>(`${this.host}/user/add`, formData);
  }

  public updateUser(formData: FormData): Observable<User | HttpErrorResponse> {
    return this.http.put<User>(`${this.host}/user/update`, formData);
  }

  public resetPassword(email: string): Observable<any | HttpErrorResponse> {
    return this.http.get(`${this.host}/user/reset/${email}`);
  }

  public deleteUser(username: string): Observable<any | HttpErrorResponse> {
    return this.http.delete<any>(`${this.host}/user/delete/${username}`);
  }

  public addUsersToLocalCache(users: User[]): void {
    localStorage.setItem('users', JSON.stringify(users));
  }

  public getUsersFromLocalCache(users: User[]): void {
    localStorage.setItem('users', JSON.stringify(users));
  }
}
