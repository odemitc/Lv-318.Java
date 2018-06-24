import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ExcategoryModel} from '../models/excategory.model';
import {environment} from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class NonExCategoryService {

  private serviceUrl = environment.serverURL + '/category';

  constructor(private http: HttpClient) {
  }

  public getByNames(name: String, nextlevel: String): Observable<ExcategoryModel[]> {
    return this.http.get<ExcategoryModel[]>(this.serviceUrl + '?firstNestedCategoryName=' + name
      + '&secondNestedCategoryName=' + nextlevel);
  }
}

