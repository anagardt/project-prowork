import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {environment} from "../environments/environment";
import {Project} from "./model/project";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private http: HttpClient) {
  }

  createNewProject(newProject: Project): Observable<Project> {
    const token = localStorage.getItem('Bearer');
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + token);
    const restApiUrl = environment.restApiUrl + environment.projectController.url + environment.projectController.newProject;
    return this.http.post<Project>(restApiUrl, newProject,
      {headers: headers});
  }
}
