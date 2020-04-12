import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs/internal/Observable";
import {environment} from "../environments/environment";
import {User} from "./model/user";
import {Issue} from "./model/issue";

@Injectable({
  providedIn: 'root'
})
export class AccessService {

  constructor(private http: HttpClient, private router: Router) {
  }

  register(newUser: User): Observable<User> {
    const restApiUrl = environment.restApiUrl + environment.accessController.url + environment.accessController.register;
    return this.http.post<User>(restApiUrl, newUser);
  }

  login(loginUser: User): Observable<any> {
    const restApiUrl = environment.restApiUrl + environment.accessController.url + environment.accessController.login;
    return this.http.post(restApiUrl, loginUser, {responseType: 'text'});
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('/login');
  }

  resetPassword(formData: FormData): Observable<any> {
    const restApiUrl = environment.restApiUrl + environment.accessController.url + environment.accessController.reset;
    return this.http.post(restApiUrl, formData, {responseType: 'text'});
  }

  resetPasswordSave(formData: FormData): Observable<any> {
    const restApiUrl = environment.restApiUrl + environment.accessController.url + environment.accessController.resetSave;
    return this.http.post(restApiUrl, formData, {responseType: 'text'});
  }
}
