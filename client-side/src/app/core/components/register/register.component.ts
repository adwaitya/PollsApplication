import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { User } from '../../models/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  signUpForm;
  message;
  constructor(private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router) {
    this.createForm();
  }


  ngOnInit() {
  }
  // Function to validate e-mail is proper format
  validateEmail(controls) {
    // Create a regular expression
    const regExp = new RegExp(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
    // Test email against regular expression
    if (regExp.test(controls.value)) {
      return null; // Return as valid email
    } else {
      return { 'validateEmail': true } // Return as invalid email
    }
  }
  // Function to create login form
  createForm() {
    this.signUpForm = this.formBuilder.group({
      name: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(30)])], // Name field
      username: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(30)])],
      email: ['', Validators.compose([Validators.required, Validators.minLength(5), Validators.maxLength(30), this.validateEmail])],
      password: ['', Validators.compose([Validators.required, Validators.minLength(6), Validators.maxLength(30)])] // Password field
    });
  }

  onRegisterSubmit() {
    const user: User = {
      name: this.signUpForm.get('name').value, // name input field
      username: this.signUpForm.get('username').value, // username input field
      email: this.signUpForm.get('email').value, // name input field
      password: this.signUpForm.get('password').value, // Password input field


    }
    this.authService.registerUser(user).subscribe(data => {
      if (!data.success) {
        this.message = data.message;
        return;
      }
      this.message = data.message;
      this.router.navigate(['/login']);
    });
  }

}
