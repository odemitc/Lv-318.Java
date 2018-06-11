import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Transit} from '../models/transit.model';

@Injectable({
  providedIn: 'root'
})
export class TransitService {

  private serviceUrl = 'http://localhost:8080/transit/';
  private addUrl = 'http://localhost:8080/transit/';

  constructor(private http: HttpClient) {
  }

  getTransits(): Observable<Transit[]> {
    return this.http.get<Transit[]>(this.serviceUrl);
  }

  addTransit(transit: Transit): Observable<Transit> {
    return this.http.post<Transit>(this.addUrl, transit);
  }

  getTransitsById(id: String): Observable<Transit[]> {
    return this.http.get<Transit[]>(this.serviceUrl + 'category/?categoryId='+id);
  }

}
