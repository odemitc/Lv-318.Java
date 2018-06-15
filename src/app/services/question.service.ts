import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable, of} from 'rxjs';
import { Injectable } from '@angular/core';
import {FeedbackCriteria} from '../models/feedback-criteria.model';
import {catchError, map, tap} from 'rxjs/operators';
import { MessageService} from './message.service';
import {promise} from 'selenium-webdriver';
import {Question} from '../models/question.model';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
export class QuestionService{
    private questionUrl = 'http://localhost:8080/question';
    constructor(private http: HttpClient,
    private  messageService: MessageService){}

    getAllQuestion(): Observable<Question[]>{
        return this.http.get<Question[]>(this.questionUrl)
        .pipe(
            tap(questions => this.log(``)),
            catchError(this.handleError('getAllQuestions', []))
        );

    }
    addQuestion(question: Question): Observable<Question> {
        return this.http.post<Question>(this.questionUrl, question, 
                httpOptions).pipe(
                tap((question: Question) => this.log(`added question w/ id=${question.id}`)),
                catchError
                (this.handleError<Question>(`addQuestion`))
            );
    }
    dalateQuestion(number): Observable<Question> {
 
       const id=number;
       const qcUrl = `${this.questionUrl}/${id}`;
       return this.http.delete<Question>(qcUrl, 
    httpOptions).pipe(
        tap(_ => this.log(`delete question id=${id}`)),
        catchError(this.handleError<Question>('deleteQuestion'))
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