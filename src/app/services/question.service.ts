import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { MessageService } from './message.service';
import { Question } from '../models/question.model';
import { Injectable } from '@angular/core';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  private questionUrl = 'http://localhost:8080/question';

  constructor(private http: HttpClient,
              private  messageService: MessageService) {
  }

  getAllQuestion(): Observable<Question[]> {
    return this.http.get<Question[]>(this.questionUrl)
      .pipe(
        tap(questions => this.log(`fetched question`)),
        catchError(this.handleError('getAllQuestions', []))
      );
  }

  addQuestion(question: Question): Observable<Question> {
    return this.http.post<Question>(this.questionUrl, question,
      httpOptions).pipe(
      tap((data: Question) => this.log(`added question w/ id=${data.id}`)),
      catchError
      (this.handleError<Question>(`addQuestion`))
    );
  }

  deleteQuestion(number): Observable<Question> {

    const id = number;
    const qcUrl = `${this.questionUrl}/${id}`;
    return this.http.delete<Question>(qcUrl,
      httpOptions).pipe(
      tap(_ => this.log(`delete question id=${id}`)),
      catchError(this.handleError<Question>('deleteQuestion'))
    );
  }

  getQuestion(id: number): Observable<Question> {
    const questionUrl = `${this.questionUrl}/${id}`;
    return this.http.get<Question>(questionUrl).pipe(
      tap(_ => this.log(`fetched question id=${id}`)),
      catchError(this.handleError<Question>(`get question id=${id}`))
    );
  }

  updateQuestion(question: Question): Observable<Question> {
    return this.http.put(this.questionUrl + '/' + question.id, question, httpOptions)
      .pipe(tap(_ => this.log(`update question id=${question.id}`)),
        catchError(this.handleError<any>('updateQuestion'))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
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
