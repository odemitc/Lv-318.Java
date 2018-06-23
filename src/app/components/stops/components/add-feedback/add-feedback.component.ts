import {Component, OnInit, Inject, Input} from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material'

import {Feedback} from '../../../../models/feedback.model';
import {FeedbackService} from '../../../../services/feedback.service';
import {FeedbackCriteriaService} from '../../../../services/feedback-criteria.service';

@Component({
  selector: 'app-add-feedback',
  templateUrl: './add-feedback.component.html',
  styleUrls: ['./add-feedback.component.css']
})
export class AddFeedbackComponent implements OnInit {

  @Input() feedbacks: Feedback[];
  @Input() feedbacksAnswers: Feedback[]=[];
  @Input() transitId: number = this.data.number;
  private questionsDatas: String[] ;
  @Input() answers: string[]  ;
  private type: String ='RATING';
  private categoryId : number=this.data.categoryId;

  constructor(private dialogRef: MatDialogRef<AddFeedbackComponent>,
              @ Inject(MAT_DIALOG_DATA) public data: any, private feedbackService: FeedbackService,
              private criteriaService: FeedbackCriteriaService) {

    this.feedbacks = this.buildFeedbacksByCriteriaType();
    this.feedbacksAnswers= new Array(this.feedbacks.length);

  }

  ngOnInit() {
  }

  buildFeedbacksByCriteriaType(): Feedback[] {
    let feedbacks: Feedback[] = [];
    this.criteriaService.getAllFeedbackCriteriaByTypeAndCategoryId(this.categoryId,this.type)
      .subscribe(feedbackCriterias => {
        feedbackCriterias.forEach(criteria => {
          this.questionsDatas = criteria.questions.map(question=>question.name);
          feedbacks.push(this.buildFeedback(criteria.id, this.questionsDatas));
        })
      });

    return feedbacks;
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

  public saveAll() {
console.log(this.feedbacks);
    this.feedbackService.addAllFeedback(this.feedbacks).subscribe(() => this.close());
  }

  public save(feedback: Feedback): void {
    console.log(feedback);
    this.feedbackService.addFeedback(feedback).subscribe(() => this.close());
  }
}
