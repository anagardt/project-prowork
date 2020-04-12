import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Project} from "../model/project";
import {Router} from "@angular/router";
import {ProjectService} from "../project.service";

@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css']
})
export class NewProjectComponent implements OnInit {

  projectForm: FormGroup;
  newProject: Project;

  constructor(private fb: FormBuilder, private router: Router,
              private projectService: ProjectService) {
  }

  ngOnInit(): void {
    this.projectForm = this.fb.group({
      name: ['', [Validators.required]]});
  }

  onSubmit() {
    const formValue = this.projectForm.value;
    const formData = new FormData();
    formData.set('email', formValue.emailAddress);
    this.projectService.createNewProject(this.newProject)
      .subscribe((response: Project) => this.router.navigateByUrl('/home'),
        (error: any) => console.error(error));
  }

  discard() {
    this.router.navigateByUrl('/home');
  }
}
