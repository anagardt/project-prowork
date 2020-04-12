import { Injectable } from '@angular/core';
import {Observable} from "rxjs/internal/Observable";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../environments/environment";
import {Issue} from "./model/issue";
import {User} from "./model/user";
import {Project} from "./model/project";

@Injectable({
  providedIn: 'root'
})
export class IssueService {

  constructor(private http: HttpClient) {
  }

  createNewIssue(formData: FormData): Observable<Issue> {
    const token = localStorage.getItem('Bearer');
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + token);
    const restApiUrl = environment.restApiUrl + environment.issueController.url + environment.issueController.newIssue;
    return this.http.post<Issue>(restApiUrl, formData,
      {headers: headers});
  }

  getAllUsers(): Observable<User[]> {
    const token = localStorage.getItem('Bearer');
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + token);
    const restApiUrl = environment.restApiUrl + environment.userController.url + environment.userController.getAll;
    return this.http.get<User[]>(restApiUrl, {headers: headers});
  }

  getAllProjects(): Observable<Project[]> {
    const token = localStorage.getItem('Bearer');
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + token);
    const restApiUrl = environment.restApiUrl + environment.projectController.url + environment.projectController.getAll;
    return this.http.get<Project[]>(restApiUrl, {headers: headers});
  }

  getAllIssues(): Observable<Issue[]> {
    const token = localStorage.getItem('Bearer');
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + token);
    const restApiUrl = environment.restApiUrl + environment.issueController.url + environment.issueController.allIssues;
    return this.http.get<Issue[]>(restApiUrl, {headers: headers});
  }

  changeIssueStatus(formData: FormData): Observable<Issue> {
    const token = localStorage.getItem('Bearer');
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + token);
    const restApiUrl = environment.restApiUrl + environment.issueController.url + environment.issueController.changeStatus;
    return this.http.post<Issue>(restApiUrl, formData, {headers: headers});
  }

  changeIssueAssignee(formData: FormData) {
    const token = localStorage.getItem('Bearer');
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + token);
    const restApiUrl = environment.restApiUrl + environment.issueController.url + environment.issueController.changeAssignee;
    return this.http.post<Issue>(restApiUrl, formData, {headers: headers});
  }

  changeIssueProject(formData: FormData) {
    const token = localStorage.getItem('Bearer');
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + token);
    const restApiUrl = environment.restApiUrl + environment.issueController.url + environment.issueController.changeProject;
    return this.http.post<Issue>(restApiUrl, formData, {headers: headers});
  }
}
