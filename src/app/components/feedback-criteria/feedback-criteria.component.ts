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

  feedbackCriterias: FeedbackCriteria[] = new MatTableDataSource(this.getAllFC());
  displayedColumns = ['id', 'type', 'weight'];

  constructor(private feedbackCriteriaService: FeedbackCriteriaService) {
  }

  ngOnInit() {

  }

  getAllFC(): FeedbackCriteria[] {
    return this.feedbackCriteriaService.getAllFC()
      .subscribe(feedbackCriterias => this.feedbackCriterias = feedbackCriterias);

  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    this.feedbackCriterias.filter = filterValue;
  }
}
