import { Component, OnInit , ViewChild } from '@angular/core';

import {FeedbackCriteria} from '../../models/feedback-criteria.model';
import {FeedbackCriteriaService} from '../../services/feedback-criteria.service';
import {MatPaginator,MatSort, MatTableDataSource} from '@angular/material';
import {SelectionModel} from '@angular/cdk/collections';

import {Observable} from 'rxjs';
import { merge, startWith, switchMap, map} from 'rxjs/operators';

@Component({
  selector: 'app-feedback-criteria',
  templateUrl: './feedback-criteria.component.html',
  styleUrls: ['./feedback-criteria.component.css']
})
export class FeedbackCriteriaComponent implements OnInit {

  feedbackCriterias: FeedbackCriteria[]; 
  displayedColumns = ['id', 'type', 'weight'];
  dataSource = new MatTableDataSource<FeedbackCriteria>();


  @ViewChild(MatPaginator) paginator: MatPaginator;
  

  constructor(private feedbackCriteriaService: FeedbackCriteriaService) {
  }

  ngOnInit() {
    this.getAllFeedbackCriteria();     
  }
т  
  getAllFeedbackCriteria(): void {
     this.feedbackCriteriaService.getAllFeedbackCriteria()
    .subscribe(feedbackCriterias => this.dataSource.data = feedbackCriterias);
    this.dataSource.paginator = this.paginator;    
  }

  deleteFeedbackCriteria(feedbackCriteria: FeedbackCriteria) {
    this.feedbackCriterias = this.feedbackCriterias.filter(f => f !== feedbackCriteria);
    this.feedbackCriteriaService.deleteFeedbackCriteria(feedbackCriteria).subscribe();    
  }
 

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
   
    
  }
}
