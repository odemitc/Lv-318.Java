import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ExcategoryModel} from "../models/excategory.model";


@Injectable({
  providedIn: 'root'
})
export class ExcategoryService {

  private serviceUrl = 'http://localhost:8080/category';

  constructor(private http: HttpClient) { }

  getTopCategories(): Observable<ExcategoryModel[]> {
    return this.http.get<ExcategoryModel[]>(this.serviceUrl+'/top/');
  }
  getCategoriesByNextLevel(nextLevel:String): Observable<ExcategoryModel[]>{
    return this.http.get<ExcategoryModel[]>(this.serviceUrl+'?top='+nextLevel);
  }

}
