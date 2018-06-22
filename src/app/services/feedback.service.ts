import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable, of} from 'rxjs';

import { environment } from '../../environments/environment';
import { Feedback } from '../models/feedback.model';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  private url = environment.serverURL + '/feedback';
feedbacks :Feedback[];
  constructor(private http: HttpClient) { 

  }
  addFeedback(feedback): Observable<Feedback> {
    return this.http.post<Feedback>(this.url ,feedback, httpOptions);
  }

  addAllFeedback(feedbacks): Observable<Feedback> {
    return this.http.post<Feedback>(this.url+ '/add' ,feedbacks, httpOptions);
  }
}
