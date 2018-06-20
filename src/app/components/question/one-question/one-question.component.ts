import { Component, Input, OnInit } from '@angular/core';
import { QuestionService } from '../../../services/question.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Question } from '../../../models/question.model';

@Component({
  selector: 'app-one-question',
  templateUrl: './one-question.component.html',
  styleUrls: ['./one-question.component.css']
})
export class OneQuestionComponent implements OnInit {
  @Input() question: Question;

  constructor(private questionService: QuestionService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit() {
    this.getQuestion();
  }

  getQuestion(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.questionService.getQuestion(id)
      .subscribe(question => this.question = question);
  }

  deleteQuestion(id: number): void {
    this.questionService.deleteQuestion(id).subscribe(() => this.gotBack());
  }

  updateQuestion(): void {
    this.questionService.updateQuestion(this.question)
      .subscribe(() => this.gotBack());
  }

  gotBack(): void {
    this.location.back();
  }

}
