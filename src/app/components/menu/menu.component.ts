import { Component, OnInit, SimpleChanges } from '@angular/core';
import { AppComponent } from '../../app.component';
import { Router } from '@angular/router';
import { GlobalSearchService } from '../../services/global-search.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  search: string = '';

  constructor(public app: AppComponent,
              private router: Router,
              private globalSearchComponent: GlobalSearchService,
              private location: Location) {

  }

  ngOnInit() {
  }

  ngOnChanges(changes: SimpleChanges) {
    console.log(this.search);
  }

  switchLanguage(language: string) {
    this.app.switchLanguage(language);
  }

  onEnter(value: string) {
    this.globalSearchComponent.setSearchValue(value);
    this.router.navigate(['search/' + '?search=/' + value]);
  }

  isHomeRouteActivated(): boolean {
    return this.location.path().indexOf('/show-transit-scheme/') > -1;
  }
}
