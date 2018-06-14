import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../../app.component';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(public app: AppComponent) {

  }

  ngOnInit() {
  }

  switchLanguage(language: string) {
    this.app.switchLanguage(language);
  }

}
