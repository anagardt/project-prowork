import {Component, OnDestroy, OnInit, Renderer2} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {User} from "../model/user";
import {ActivatedRoute, Router} from "@angular/router";
import {AccessService} from "../access.service";

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit, OnDestroy {

  resetForm: FormGroup;
  matchingPasswordsError = false;
  errorMessage: string;
  errorDisplay = false;
  token: String;

  constructor(private fb: FormBuilder, private accessService: AccessService,
              private router: Router, private renderer: Renderer2,
              private activatedRoute: ActivatedRoute) {
    this.renderer.addClass(document.body, 'body-color');
    if (localStorage.getItem('Bearer') !== null) {
      this.router.navigateByUrl('/home');
    }
    this.activatedRoute.queryParams.subscribe(params => {
      this.token = params['token'];
      });
  }

  ngOnDestroy(): void {
    this.renderer.removeClass(document.body, 'body-color');
  }

  ngOnInit() {
    this.resetForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(20)]],
      password: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(25)]],
      confirmPassword: ['', [Validators.required]]
    }, {validator: this.matchingPasswordsValidator});
  }

  onSubmit() {
    const formValue = this.resetForm.value;
    const formData = new FormData();
    formData.set('username', formValue.username);
    formData.set('password', formValue.password);
    formData.set('token', ''+this.token );
    this.accessService.resetPasswordSave(formData)
      .subscribe(
        (user: User) => {
          console.log(user);
          this.router.navigateByUrl('/login');
        },
        (error: any) => {
          this.errorMessage = error.error.message;
          this.errorDisplay = true;
        }
      );
  }

  goBack() {
    this.router.navigateByUrl('/login');
  }

  matchingPasswordsValidator(control: AbstractControl) {
    if (control.get('password').value !== control.get('confirmPassword').value) {
      return {invalid: true};
    }
  }

}
