import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {LoginHelpComponent} from "./login-help/login-help.component";
import {EditUserComponent} from "./edit-user/edit-user.component";
import {LoggedHeaderComponent} from "./logged-header/logged-header.component";
import {NewIssueComponent} from "./new-issue/new-issue.component";
import {HeaderComponent} from "./header/header.component";
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {HomeComponent} from "./home/home.component";
import {IssueService} from "./issue.service";
import {CommentService} from "./comment.service";
import {AuthGuardService} from "./auth-guard.service";
import { NewProjectComponent } from './new-project/new-project.component';
import {ProjectService} from "./project.service";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    HeaderComponent,
    NewIssueComponent,
    LoggedHeaderComponent,
    EditUserComponent,
    LoginHelpComponent,
    NewProjectComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [IssueService, CommentService, ProjectService, AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
