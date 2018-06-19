import { Component, OnInit,Inject,Input,OnChanges } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { Observable } from 'rxjs';

import { Feedback } from '../../../../models/feedback.model';
import { FeedbackService } from '../../../../services/feedback.service';



@Component({
  selector: 'app-add-feedback',
   templateUrl: './add-feedback.component.html',
  styleUrls: ['./add-feedback.component.css']
})
export class AddFeedbackComponent  {
  @Input()  feedback: Feedback = new Feedback;
@Input() transitId: number=this.data.number;

constructor(private dialogRef : MatDialogRef<AddFeedbackComponent>,
  @ Inject(MAT_DIALOG_DATA) public data:any, private feedbackService: FeedbackService,
  private router: Router, private location: Location) { 

  }
  
public close(){
  this.dialogRef.close();
}

public save(): void{
  this.feedback.userId=1;
  this.feedback.criteriaId=1;
  this.feedback.transitId=this.data.number;
  this.feedbackService.addFeedback(this.feedback)
  .subscribe(() => this.gotBack());
  this.dialogRef.close();
}

gotBack(): void {
  this.location.back();
}

}
