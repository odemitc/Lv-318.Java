import { Component, OnInit } from '@angular/core';

import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";
import {Login} from '../../models/login.model';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent {


  login: Login = new Login();

  constructor(private router: Router, private userService: UserService) {

  }

  logIn(): void {
    this.userService.logIn(this.login)
      .subscribe(data => {
        alert('User loged successfully.');
      });

  }


}
