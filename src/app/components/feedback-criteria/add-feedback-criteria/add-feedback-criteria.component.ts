import { Component, OnInit } from '@angular/core';
import { FeedbackCriteriaComponent } from '../feedback-criteria.component';
import { AddQuestionComponent } from '../add-question/add-question.component';
import {FeedbackCriteria} from '../../../models/feedback-criteria.model'; 
import { FeedbackCriteriaService } from '../../../services/feedback-criteria.service';
import { Location } from '@angular/common';
import {MatDialog, MatDialogConfig} from '@angular/material';
import { Question } from '../../../models/question.model';
import { EnumType } from '../../../models/enum-type-model';
import { map } from 'rxjs/operators';
@Component({
  selector: 'app-add-feedback-criteria',
  templateUrl: './add-feedback-criteria.component.html',
  styleUrls: ['./add-feedback-criteria.component.css']
})
export class AddFeedbackCriteriaComponent implements OnInit {

  feedbackCriteria = new FeedbackCriteria();
  questions: Question [] = [];
  enumTypes: any;
 
  constructor(private feedbackCriteriaService: FeedbackCriteriaService,
  private location: Location,
  private dialog: MatDialog) { }

  ngOnInit() {
   this.getAllEnumTypes();
   
  }
  
  openDialog(): void {
    let dialogRef = this.dialog.open(AddQuestionComponent, {
      width: '600px',
      data: {}
    });
    dialogRef.afterClosed().subscribe(result => {
      this.questions.push(result);
    });
 
  }    

  addFeedbackCriteria(): void{
    this.feedbackCriteria.questions = this.questions;
    this.feedbackCriteriaService.addFeedbackCritea(this.feedbackCriteria)
    .subscribe(() => this.gotBack());
  }
  
  gotBack(): void {
    this.location.back();
  }

  getAllEnumTypes(): void{
    this.feedbackCriteriaService.getAllEnumTypes()
    .subscribe(enumType =>{
      this.enumTypes=enumType;
      console.log(enumType);
    } );
      // for (let prop in enumType) {
      //   this.enumTypes.push(prop);
      // }
      // for (let val of Object.values(enumType)) {
      //   this.enumTypes.push(val.toString());
      // }
    
      // this.enumTypes=Array.from(Object.values(enumType))
  
  }

}
