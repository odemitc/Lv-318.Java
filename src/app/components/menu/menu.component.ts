import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../../app.component';
import {TokenStorage} from "../../services/auth/token/token-storage";
import {Router} from "@angular/router";


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(public app: AppComponent, private router: Router, private tokenStorage: TokenStorage) {

  }

  ngOnInit() {
  }

  switchLanguage(language: string) {
    this.app.switchLanguage(language);
  }

  hasToken(): boolean {
    return this.tokenStorage.hasToken();
  }

  logOut() {
    this.tokenStorage.signOut();
    this.router.navigate(['main']);
  }
}
