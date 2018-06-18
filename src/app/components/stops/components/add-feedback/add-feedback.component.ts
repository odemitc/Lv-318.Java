import { Component, OnInit,Inject,Input,OnChanges } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormGroup, FormControl,FormBuilder ,Validators,  } from '@angular/forms';
import { Router } from '@angular/router';

import { Feedback } from '../../../../models/feedback.model';
import { FeedbackService } from '../../../../services/feedback.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-add-feedback',
   templateUrl: './add-feedback.component.html',
  styleUrls: ['./add-feedback.component.css']
})
export class AddFeedbackComponent implements OnInit, OnChanges {
   feedbackForm: FormGroup;
  @Input()  feedback: Feedback;
  @Input() answer: string;


constructor(private dialogRef : MatDialogRef<AddFeedbackComponent>,@ Inject(MAT_DIALOG_DATA) public data:any,
private fb: FormBuilder, private feedbackService: FeedbackService,private router: Router) { 
  this.initForm();

  }

  ngOnInit() {
    
  }

  initForm(){
    this.feedbackForm = this.fb.group({
      'answer':[1]
    
    });
  }
// public buildFeedback(): Feedback{
//   this.feedbackForm.get(['answer','userId','criteriaId']).valueChanges
//   .subscribe( this.feedback.answer=this.feedbackForm.value.answer,
//     this.feedback.userId=this.feedbackForm.value.userId,
//     this.feedback.criteriaId=this.feedbackForm.value.criteriaId);
//  this.feedback.transitId = this.data.number;
//   return this.feedback;
// }
public onSubmit() {
 this.feedback=this.feedbackForm.value;
  this.feedback.transitId=this.data.number;
  this.feedback.userId=1;
  this.feedback.criteriaId=1;
  this.feedbackService.addFeedback(this.feedback);
}
  
public close(){
  this.dialogRef.close();
}
ngOnChanges() {
  this.rebuildForm();
}
rebuildForm() {
  this.feedbackForm.reset({
    answer: this.feedback.answer,

  });
}


}
