import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpResponse} from "@angular/common/http";
import { environment } from "../../environments/environment";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private host = environment.apiUrl;

  constructor(private http: HttpClient) { }

  public login(): Observable<HttpResponse<any> | HttpErrorResponse> {

  }
}
