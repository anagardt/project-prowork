import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AuthGuardService} from "./auth-guard.service";
import {NewIssueComponent} from "./new-issue/new-issue.component";
import {HomeComponent} from "./home/home.component";
import {RegisterComponent} from "./register/register.component";
import {LoginHelpComponent} from "./login-help/login-help.component";
import {LoginComponent} from "./login/login.component";
import {NewProjectComponent} from "./new-project/new-project.component";
import {EditUserComponent} from "./edit-user/edit-user.component";



const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'login-help',
    component: LoginHelpComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'home',
    component: HomeComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'new-issue',
    component: NewIssueComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'new-project',
    component: NewProjectComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'edit-user',
    component: EditUserComponent,
  },
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
