import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../../environments/environment';
import { tokenNotExpired } from 'angular2-jwt';
import { JwtAuthenticationResponse } from '../models/JwtAuthenticationResponse';
import { ApiResponse } from '../models/ApiResponse';
import { LoginModel } from '../models/loginModdel';

@Injectable()
export class AuthService {

  authToken;
  user;
  options;
  domain = environment.apiUrl;
  constructor(private http: HttpClient) {

  }

  // Register 
  registerUser(user: User): Observable<ApiResponse> {
    const headers = new HttpHeaders().set('content-type', 'application/json');
    const body = {
      name: user.name, username: user.username, email: user.email, password: user.password
    }
    return this.http.post<ApiResponse>(this.domain + '/api/auth/signup', body, { headers });

  }


  // Function to get token from client local storage

  getToken(): string {

    return localStorage.getItem('token');

  }
  getLoggedInUser(): string {

    return localStorage.getItem('user');

  }
  // Function to login user
  login(user: LoginModel): Observable<JwtAuthenticationResponse> {
    const headers = new HttpHeaders().set('content-type', 'application/json');
    const body = {
      usernameOrEmail: user.usernameOrEmail, password: user.password
    }
    return this.http.post<JwtAuthenticationResponse>(this.domain + '/api/auth/signin', body);
  }
  // Function to store user's data in client local storage
  storeUserData(token, user) {
    localStorage.setItem('token', token); // Set token in local storage
    localStorage.setItem('user', user); // Set user in local storage as string
    this.authToken = token; // Assign token to be used elsewhere
    this.user = user; // Set user to be used elsewhere
  }
  // Function to logout
  logout() {
    this.authToken = null; // Set token to null
    this.user = null; // Set user to null
    localStorage.clear(); // Clear local storage
  }
  public isAuthenticated(): boolean {
    // get the token
    this.authToken = this.getToken();
    // return a boolean reflecting 
    // whether or not the token is expired
    return tokenNotExpired(null, this.authToken);
  }
  // Function to check if user is logged in
  loggedIn() {
    return tokenNotExpired();
  }

}