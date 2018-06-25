import {Component, OnInit, Inject, Input} from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA, MAT_CHIPS_DEFAULT_OPTIONS} from '@angular/material'

import {Feedback, FeedbackDTO} from '../../../../models/feedback.model';
import {FeedbackService} from '../../../../services/feedback.service';
import {FeedbackCriteriaService} from '../../../../services/feedback-criteria.service';
import {FeedbackCriteria} from '../../../../models/feedback-criteria.model';

@Component({
  selector: 'app-add-feedback',
  templateUrl: './add-feedback.component.html',
  styleUrls: ['./add-feedback.component.css']
})
export class AddFeedbackComponent implements OnInit {

  @Input() feedbacks: Feedback[] = [];
  @Input() capacityFeedbacks: Feedback[];
  @Input() transitId: number = this.data.number;
  private categoryId: number = this.data.categoryId;
  private questionsDatas: String[];


  constructor(private dialogRef: MatDialogRef<AddFeedbackComponent>, @ Inject(MAT_DIALOG_DATA) public data: any,
              private feedbackService: FeedbackService, private criteriaService: FeedbackCriteriaService) {

    this.feedbacks = this.buildFeedbacksByCriteriaType(['RATING', 'ACCEPTER']);
    this.capacityFeedbacks = this.buildFeedbacksByCriteriaType(['ROUTE_CAPACITY', 'HOURS_CAPACITY']);

  }

  ngOnInit() {
    console.log(this.feedbacks);

  }

  buildFeedbacksByCriteriaType(types: String []): Feedback[] {
    let feedbacks: Feedback[] = [];
    types.forEach(type => {
      this.criteriaService.getAllFeedbackCriteriaByTypeAndCategoryId(this.categoryId, type)
        .subscribe(feedbackCriterias => {
          feedbackCriterias.forEach(criteria => {
            this.questionsDatas = criteria.questions.map(question => question.name);
            let feedback: Feedback = this.buildFeedback(criteria, this.questionsDatas);
            // this.setAnswer(criteria.type,feedback);
            feedbacks.push(feedback);
          })
        });
    });
    return feedbacks;
  }

  public buildFeedback(criteria: FeedbackCriteria, questions: String[]): Feedback {
    let feedback: Feedback = new Feedback();
    feedback.transitId = this.data.number;
    feedback.userId = 1;
    feedback.criteriaId = criteria.id;
    feedback.type = criteria.type;
    feedback.questions = questions;
    return feedback;
  }

  public close() {
    this.dialogRef.close();
  }

  public saveAllFeedback(): void {
    console.log(this.feedbacks);

    this.feedbackService.saveAllFeedback(this.toDTOList(this.feedbacks)).subscribe(data => {
      alert('Feedback created successfully.');
    });
  }


  public toDTOList(feedbacks: Feedback[]): FeedbackDTO[] {
    let feedbackDTOs: Feedback[] = [];
    feedbacks.forEach(feedback => {
      let feedbackDTO: Feedback = new Feedback();
      feedbackDTO.transitId = feedback.transitId;
      feedbackDTO.userId = feedback.userId;
      feedbackDTO.criteriaId = feedback.criteriaId;
      feedbackDTO.type = feedback.type;
      feedbackDTO.answer = feedback.answer;
      feedbackDTOs.push(feedbackDTO);
    });
    return feedbackDTOs;
  }
}
