import {Component, HostListener, Input, OnInit} from '@angular/core';
import {ExcategoryModel} from "../../models/excategory.model";
import {ExcategoryService} from "../../services/excategory.service";
import {Observable} from "rxjs/index";
import {NonExCategoryComponent} from "../non-ex-category/non-ex-category.component";

@Component({
  selector: 'app-excategory',
  templateUrl: './excategory.component.html',
  styleUrls: ['./excategory.component.css']
})
export class ExcategoryComponent implements OnInit {
  private list: Observable<ExcategoryModel[]> = this.service.getTopCategories();
  private cities: Observable<ExcategoryModel[]>;



  constructor(public service: ExcategoryService) {
  }

  ngOnInit() {
    this.list = this.service.getTopCategories();
  }

  getCities(nextLevel: String) {
    this.cities = this.service.getCategoriesByNextLevel(nextLevel);
  }

}
