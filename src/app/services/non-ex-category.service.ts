import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ExcategoryModel } from '../models/excategory.model';
import { Settings } from '../settings';


@Injectable({
  providedIn: 'root'
})
export class NonExCategoryService {

  private serviceUrl = Settings.URL + '/category/';

  constructor(private http: HttpClient) {
  }

  public getByNames(name: String, nextlevel: String): Observable<ExcategoryModel[]> {
    return this.http.get<ExcategoryModel[]>(this.serviceUrl + 'get?name=' + name + '&next=' + nextlevel);
  }
}

