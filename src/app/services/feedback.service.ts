import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { Feedback } from '../models/feedback.model';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  private url = environment.serverURL + '/feedback';

  constructor(private http: HttpClient) { 

  }
  addFeedback(feedback:Feedback)  {
     this.http.post<Feedback>(this.url, JSON.stringify(feedback),httpOptions)
              .subscribe(res => console.log(res),
            err => console.log(err)
            );
  }

  addAllFeedback(feedbacks: Feedback[]) {
    // const feedbackUrl = `${this.url}/add?feedbacks[]=${feedbacks}`;
    const feedbackUrl = `${this.url}/add`;
    this.http.post<Feedback[]>(feedbackUrl, JSON.stringify(feedbacks), httpOptions).subscribe(
      feedbacks => console.log(JSON.stringify(feedbacks)));
  }
}
