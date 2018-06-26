import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../../app.component';
import { Location } from '@angular/common';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(public app: AppComponent,private location: Location) {

  }

  ngOnInit() {
  }

  switchLanguage(language: string) {
    this.app.switchLanguage(language);
  }
}
