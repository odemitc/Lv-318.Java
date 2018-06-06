import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable, Subject, asapScheduler, pipe, of, from, interval, merge, fromEvent } from 'rxjs';


@Injectable()
export class FeedbackCService {

  constructor(private  http: HttpClient) {}
  getAll(): Observable<any> {
    return this.http.get('http://localhost:8080/feedback-criteria');
  }
}
