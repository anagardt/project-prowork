import {Component, OnDestroy, OnInit, Renderer2} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AccessService} from '../access.service';
import {User} from "../model/user";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {

  loginForm: FormGroup;
  errorMessage: string;
  errorDisplay = false;
  loginUser: User;

  constructor(private fb: FormBuilder, private accessService: AccessService,
              private router: Router, private renderer: Renderer2) {
    this.renderer.addClass(document.body, 'body-color');
    if (localStorage.getItem('Bearer') !== null) {
      this.router.navigateByUrl('/home');
    }
  }

  ngOnDestroy(): void {
    this.renderer.removeClass(document.body, 'body-color');
  }


  ngOnInit() {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    const formValue = this.loginForm.value;
    this.loginUser = new User();
    this.loginUser.username = formValue.username;
    this.loginUser.password = formValue.password;
    this.accessService.login(this.loginUser)
      .subscribe(
        (jwtToken: any) => {
          localStorage.setItem('Bearer', jwtToken);
          localStorage.setItem('User', formValue.username);
          this.router.navigateByUrl('/home');
        },
        (error: any) => {
          if (error.status === 500) {
            const errorObj = JSON.parse(error.error);
            this.errorMessage = errorObj.message;
            this.errorDisplay = true;
          }
        }
      );
  }

  goToRegister() {
    this.router.navigateByUrl('/register');
  }

  navigateToLoginHelp() {
    this.router.navigateByUrl('/login-help');
  }
}
