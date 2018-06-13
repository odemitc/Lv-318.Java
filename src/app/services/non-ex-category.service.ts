import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ExcategoryModel} from '../models/excategory.model';


@Injectable({
  providedIn: 'root'
})
export class NonExCategoryService {

  private serviceUrl = 'http://localhost:8080/category/';

  constructor(private http: HttpClient) {
  }

  public getByNames(name: String, nexlevel: String): Observable<ExcategoryModel[]> {
    return this.http.get<ExcategoryModel[]>(this.serviceUrl + 'get?name=' + name + '&next=' + nexlevel);
  }
}

