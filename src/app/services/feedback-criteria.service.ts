import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable, of} from 'rxjs';
import { Injectable } from '@angular/core';
import {FeedbackCriteria} from '../models/feedback-criteria.model';
import {catchError, map, tap} from 'rxjs/operators';
import { MessageService} from './message.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class FeedbackCriteriaService {
  private fcUrl = 'http://localhost:8080/feedback-criteria';

  constructor(private  http: HttpClient,
              private messageService: MessageService) {}

  getAllFC(): Observable<FeedbackCriteria[]> {
    return this.http.get<FeedbackCriteria[]>(this.fcUrl)
      .pipe(
        tap(feedbackCriterias => this.log(`fetched heroes`)),
        catchError(this.handleError('getAllFeedbackCriterias', []))
      );

  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error);

      this.log(`${operation} failed: ${error.message}`);

      return of(result as T);
    };

  }
  private log(message: string) {
    this.messageService.add('HeroService: ' + message);
  }
}
