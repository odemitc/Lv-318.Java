import { Injectable } from '@angular/core';
import * as auth0 from 'auth0-js';
import { environment } from './../../../environments/environment';
import { Router } from '@angular/router';

(window as any).global = window;

@Injectable()
export class AuthService {
    auth0 = new auth0.WebAuth({
    clientID: environment.auth.clientID,
    domain: environment.auth.domain,
    responseType: 'token',
    redirectUri: environment.auth.redirect,
    audience: environment.auth.audience,
    scope: environment.auth.scope
  });

  public isAuthenticated: boolean;

  constructor(private router: Router) {
    this.getAccessToken();
  }



  expiresAt: number;
  userProfile: any;
  accessToken: string;
  authenticated: boolean;


  login() {
    this.auth0.authorize();
  }

  handleLoginCallback() {
    this.auth0.parseHash((err, authResult) => {
      if (authResult && authResult.accessToken) {
        window.location.hash = '';
        this.getUserInfo(authResult);
      } else if (err) {
        console.error(`Error: ${err.error}`);
      }
      this.router.navigate(['/']);
    });
  }

  getAccessToken() {
    this.auth0.checkSession({}, (err, authResult) => {
      if (authResult && authResult.accessToken) {
        this.getUserInfo(authResult);
      }
    });
  }

  getUserInfo(authResult) {
    this.auth0.client.userInfo(authResult.accessToken, (err, profile) => {
      if (profile) {
        this._setSession(authResult, profile);
      }
    });
  }

  private _setSession(authResult, profile) {
    this.expiresAt = authResult.expiresIn * 1000 + Date.now();
    this.accessToken = authResult.accessToken;
    this.userProfile = profile;
    this.authenticated = true;
  }

  // logout() {
  //     this.auth0.logout({
  //     returnTo: 'http://localhost:4200',
  //     clientID: environment.auth.clientID
  //   });
  // }

  get isLoggedIn(): boolean {
    return Date.now() < this.expiresAt && this.authenticated;
  }

}
