import {Component, OnInit, Inject, Input, OnChanges, AfterViewInit} from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {Router} from '@angular/router';

import {Feedback} from '../../../../models/feedback.model';
import {FeedbackService} from '../../../../services/feedback.service';
import {FeedbackCriteriaService} from '../../../../services/feedback-criteria.service';
import {FeedbackCriteria} from '../../../../models/feedback-criteria.model';
import {Question} from '../../../../models/question.model';
import {QuestionService} from '../../../../services/question.service';

@Component({
  selector: 'app-add-feedback',
  templateUrl: './add-feedback.component.html',
  styleUrls: ['./add-feedback.component.css']
})
export class AddFeedbackComponent implements OnInit {

  @Input() feedbacks: Feedback[];
  @Input() transitId: number = this.data.number;
  private feedbackCriterias: FeedbackCriteria[];
  private questions: Question [] = [];
  private questionsDatas: String[] = [];


  constructor(private dialogRef: MatDialogRef<AddFeedbackComponent>,
              @ Inject(MAT_DIALOG_DATA) public data: any, private feedbackService: FeedbackService,
              private criteriaService: FeedbackCriteriaService, private questionService: QuestionService,
              private router: Router) {

    this.feedbacks = this.buildFeedbacksByCriteriaType();

  }

  ngOnInit() {
    console.log(this.feedbacks);
  }


  buildFeedbacksByCriteriaType(): Feedback[] {
    let feedbacks: Feedback[] = [];
    this.criteriaService.getAllFeedbackCriteriaByType()
      .subscribe(feedbackCriterias => {
        feedbackCriterias.forEach(criteria => {
          this.questionsDatas = this.getAllQuestionsByCriteriaId(criteria.id);
          feedbacks.push(this.buildFeedback(criteria.id, this.questionsDatas));
        })
      });
    return feedbacks;

  }

  getAllFeedbackCriteriaByType(): FeedbackCriteria[] {
    let criterias: FeedbackCriteria[] = [];
    this.criteriaService.getAllFeedbackCriteriaByType()
      .subscribe(feedbackCriterias => {
        feedbackCriterias.forEach(criteria =>
          criterias.push(criteria));
      });
    return criterias;

  }

  getAllQuestionsByCriteriaId(id: number): String[] {
    let questions: String[] = [];
    this.questionService.getAllQuestionByCriteriaId(id)
      .subscribe(questionsData => {
        questionsData.forEach(question =>
          questions.push(question.name));
      });
    return questions;
  }

  public buildFeedback(criteriaId: number, questions: String[]): Feedback {
    let feedback: Feedback = new Feedback();
    feedback.transitId = this.data.number;
    feedback.userId = 1;
    feedback.criteriaId = criteriaId;
    feedback.questions = questions;
    return feedback;
  }

  public close() {
    this.dialogRef.close();
  }

  public saveAll(): void {
    this.feedbackService.addAllFeedback(this.feedbacks);

  }
}
