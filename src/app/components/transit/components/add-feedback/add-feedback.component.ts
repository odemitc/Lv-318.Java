import {Component, OnInit, Inject, Input} from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA, MAT_CHIPS_DEFAULT_OPTIONS} from '@angular/material'

import {Feedback, FeedbackDTO} from '../../../../models/feedback.model';
import {FeedbackService} from '../../../../services/feedback.service';
import {FeedbackCriteriaService} from '../../../../services/feedback-criteria.service';
import {FeedbackCriteria} from '../../../../models/feedback-criteria.model';
import {Transit} from '../../../../models/transit.model';

@Component({
  selector: 'app-add-feedback',
  templateUrl: './add-feedback.component.html',
  styleUrls: ['./add-feedback.component.css']
})
export class AddFeedbackComponent {
  @Input() transitName: String = this.data.transitName;
  @Input() feedbacks: Feedback[] = [];
  @Input() capacityFeedbacks: Feedback[];
  @Input() transitId: number = this.data.number;
  private categoryId: number = this.data.categoryId;
  private questionsDatas: String[];
  private checkBoxAnswers: String[] = ['YES', 'NO', 'MAYBE'];


  constructor(private dialogRef: MatDialogRef<AddFeedbackComponent>, @ Inject(MAT_DIALOG_DATA) public data: any,
              private feedbackService: FeedbackService, private criteriaService: FeedbackCriteriaService) {
    this.feedbacks = this.buildFeedbacksByCriteriaType(['RATING', 'ACCEPTER']);
    this.capacityFeedbacks = this.buildFeedbacksByCriteriaType(['ROUTE_CAPACITY', 'HOURS_CAPACITY']);

  }

  buildFeedbacksByCriteriaType(types: String []): Feedback[] {
    let feedbacks: Feedback[] = [];
    types.forEach(type => {
      this.criteriaService.getAllFeedbackCriteriaByTypeAndCategoryId(this.categoryId, type)
        .subscribe(feedbackCriterias => {
          feedbackCriterias.forEach(criteria => {
            this.questionsDatas = criteria.questions.map(question => question.name);
            let feedback: Feedback = this.buildFeedback(criteria, this.questionsDatas);
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
    let feedbackDTOs: FeedbackDTO[] = this.toDTOList(this.feedbacks);
    this.feedbackService.saveAllFeedback(feedbackDTOs).subscribe(data => {
      alert('Feedback created successfully.');
    });

    this.dialogRef.close();
  }


  public toDTOList(feedbacks: Feedback[]): FeedbackDTO[] {
    let feedbackDTOs: FeedbackDTO[] = [];
    feedbacks.forEach(feedback => {
      if (feedback.answer && feedback.answer.length > 0) {
        let feedbackDTO: Feedback = new Feedback();
        feedbackDTO.transitId = feedback.transitId;
        feedbackDTO.userId = feedback.userId;
        feedbackDTO.criteriaId = feedback.criteriaId;
        feedbackDTO.type = feedback.type;
        feedbackDTO.answer = feedback.answer;
        feedbackDTOs.push(feedbackDTO);
      }
    });
    return feedbackDTOs;
  }
}
