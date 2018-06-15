import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable, of} from 'rxjs';
import { Injectable } from '@angular/core';
import {FeedbackCriteria} from '../models/feedback-criteria.model';
import {catchError, map, tap} from 'rxjs/operators';
import { MessageService} from './message.service';
import {promise} from 'selenium-webdriver';
// import {MatTableDataSource} from '@angular/material';
// import filter = promise.filter;


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class FeedbackCriteriaService {
  private feedbackCriteriaUrl = 'http://localhost:8080/feedback-criteria';


  constructor(private  http: HttpClient,
              private messageService: MessageService) {}

  getAllFeedbackCriteria(): Observable<FeedbackCriteria[]> {
    return this.http.get<FeedbackCriteria[]>(this.feedbackCriteriaUrl)
      .pipe(
        tap(feedbackCriterias => this.log(`fetched feedbackCriterias`)),
        catchError(this.handleError('getAllFeedbackCriterias', []))
      );
  }
  deleteFeedbackCriteria(feedbackCriteria: FeedbackCriteria | number): Observable<FeedbackCriteria> {
    const id = typeof feedbackCriteria === 'number' ? feedbackCriteria : feedbackCriteria.id;
    const url = `${this.feedbackCriteriaUrl}/{id}`;
    return this.http.delete<FeedbackCriteria>(url, httpOptions)
    .pipe(
      tap(_ => this.log(`deleted feedbackCriteria id=${id}`)),
      catchError(this.handleError<FeedbackCriteria>('deletefeedbackCriteria'))
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
