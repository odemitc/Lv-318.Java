import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transit } from '../models/transit.model';
import { Settings } from '../settings';

@Injectable({
  providedIn: 'root'
})
export class TransitService {

  private serviceUrl = Settings.URL + '/transit/';

  constructor(private http: HttpClient) {
  }

  getTransits(): Observable<Transit[]> {
    return this.http.get<Transit[]>(this.serviceUrl);
  }

  addTransit(transit: Transit): Observable<Transit> {
    return this.http.post<Transit>(this.serviceUrl, transit);
  }

  getTransitsById(id: String): Observable<Transit[]> {
    return this.http.get<Transit[]>(this.serviceUrl + '?categoryId=' + id);
  }
}
