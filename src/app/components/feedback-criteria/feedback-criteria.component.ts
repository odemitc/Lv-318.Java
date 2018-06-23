import {Component, OnInit, ViewChild} from '@angular/core';

import {FeedbackCriteria} from '../../models/feedback-criteria.model';
import {FeedbackCriteriaService} from '../../services/feedback-criteria.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { filter } from 'rxjs/operators';
import { Question } from '../../models/question.model';

@Component({
  selector: 'app-feedback-criteria',
  templateUrl: './feedback-criteria.component.html',
  styleUrls: ['./feedback-criteria.component.css']
})
export class FeedbackCriteriaComponent implements OnInit {

  feedbackCriterias: FeedbackCriteria[];
  displayedColumns = ['type', 'weight', 'questions'];
  dataSource = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private feedbackCriteriaService: FeedbackCriteriaService) {
  }

  ngOnInit() {
    this.getAllFeedbackCriteria();

  }
  

  getAllFeedbackCriteria(): void {
    this.feedbackCriteriaService.getAllFeedbackCriteria()
      .subscribe(feedbackCriterias => this.dataSource.data = feedbackCriterias);
    this.dataSource.paginator = this.paginator;
    
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter=filterValue;
    filterValue = filterValue.toUpperCase();
    this.dataSource.filter = filterValue;       
    this.dataSource.filterPredicate = (data, filter) =>
    JSON.stringify(data).includes(filter);
  }
}
