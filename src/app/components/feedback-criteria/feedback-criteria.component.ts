import { Component, OnInit } from '@angular/core';

import {FeedbackCriteria} from '../../models/feedback-criteria.model';
import {FeedbackCriteriaService} from '../../services/feedback-criteria.service';
import {MatTableDataSource} from '@angular/material';
import {Observable} from 'rxjs';


@Component({
  selector: 'app-feedback-criteria',
  templateUrl: './feedback-criteria.component.html',
  styleUrls: ['./feedback-criteria.component.css']
})
export class FeedbackCriteriaComponent implements OnInit {


  feedbackCriterias: FeedbackCriteria[];
  displayedColumns = ['id', 'type', 'weight'];

  constructor(private feedbackCriteriaService: FeedbackCriteriaService) {
  }

  ngOnInit() {
    this.getAllFC();
  }

  getAllFC(): void {
       this.feedbackCriteriaService.getAllFC()
      .subscribe(feedbackCriterias => this.feedbackCriterias = feedbackCriterias);

  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    // this.feedbackCriterias.filter = filterValue;
  }
}
