import {Component, OnDestroy, OnInit, Renderer2} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {Project} from "../model/project";
import {User} from "../model/user";
import {AccessService} from "../access.service";

@Component({
  selector: 'app-login-help',
  templateUrl: './login-help.component.html',
  styleUrls: ['./login-help.component.css']
})
export class LoginHelpComponent implements OnInit, OnDestroy {

  emailAddressForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router,
              private renderer: Renderer2,
              private accessService: AccessService) {
    this.renderer.addClass(document.body, 'body-color');
    if (localStorage.getItem('Bearer') !== null) {
      this.router.navigateByUrl('/home');
    }
  }

  ngOnInit() {
    this.emailAddressForm = this.fb.group({
      emailAddress: ['', Validators.required]
    });
  }

  ngOnDestroy(): void {
    this.renderer.removeClass(document.body, 'body-color');
  }

  onSubmit() {
    const formValue = this.emailAddressForm.value;
    const formData = new FormData();
    formData.set('email', formValue.emailAddress);
    this.accessService.resetPassword(formData)
      .subscribe((response: User) => this.router.navigateByUrl('/login'),
        (error: any) => console.error(error));
  }

  goBack() {
    this.router.navigateByUrl('/login');
  }
}
