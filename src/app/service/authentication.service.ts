import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private host: string = environment.apiUrl;

  constructor() { }
}
