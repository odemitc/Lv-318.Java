import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Login } from '../../models/login.model';
import { TokenStorage } from "../../services/auth/token/token-storage";
import {TokenModel} from "../../services/auth/token/token-model";
import {AuthService} from "../../services/auth/auth.service";

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent {
  public users: Array<Login> = [
    {
      email: 'johndoe@gmail.com',
      password: 'secret'
    }
  ];

  login: Login = new Login();

  constructor(private router: Router, private authService: AuthService, private tokenStorage: TokenStorage) {

  }

  // logIn(): void {
  //   this.userService.logIn(this.login)
  //     .subscribe((token: TokenModel) => {
  //       this.tokenStorage.saveToken(token);
  //       alert('User loged successfully.');
  //       this.router.navigate(['main']);
  //     });
  //
  // }
  logIn = () => {
    this.authService.signIn(this.login)
      .subscribe((token: TokenModel) => {
        this.tokenStorage.saveToken(token);
        alert('User loged successfully.');
        this.router.navigate(['main']);
      });

  };

 }
