import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { FormBuilder, Validators, FormControl, FormGroup } from '@angular/forms';
import { User } from '../../models/user';
import { LoginModel } from '../../models/loginModdel';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  signInForm;

  constructor(private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router) {
    this.createForm();
  }

  ngOnInit() {
  }

  // Function to create login form
  createForm() {
    this.signInForm = this.formBuilder.group({
      usernameOrEmail: ['', Validators.required], // Username field
      password: ['', Validators.required] // Password field
    });
  }

  // submit login form functionality 
  // Functiont to submit form and login user
  onLoginSubmit() {
    const user: LoginModel = {
      usernameOrEmail: this.signInForm.get('usernameOrEmail').value, // Username input field
      password: this.signInForm.get('password').value, // Password input field


    }

    // Function to send login data to API
    this.authService.login(user).subscribe(data => {
      if (data.result) {
        console.log(data.usernameOrEmail);
        this.authService.storeUserData(data.accessToken, data.usernameOrEmail);
        this.router.navigate(['/profile']);
      }
    }, error => {
      console.log(error.error.message);
    }
    );

  }
}
