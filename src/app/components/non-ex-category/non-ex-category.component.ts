import { Component, HostBinding, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Observable} from "rxjs/index";
import {ExcategoryModel} from "../../models/excategory.model";
import {NonExCategoryService} from "../../services/non-ex-category.service";
import {Category} from '../../models/category';

@Component({
  selector: 'app-non-ex-category',
  templateUrl: './non-ex-category.component.html',
  styleUrls: ['./non-ex-category.component.css']
})
export class NonExCategoryComponent implements OnInit {
  private list: Observable<ExcategoryModel[]>;

  top: String;
  city: String;
  private sub: any;


  constructor(private service: NonExCategoryService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.sub = this.route.params.forEach(params => {
      this.top = params['top'];
      this.city = params['city'];
      this.list = this.service.getByNames(this.city, this.top);
    });
  }

  deleteCategory(category: Category): void {
    this.service.deleteCategory(category);
    this.list = this.service.getByNames(this.city, this.top);
      }
}
