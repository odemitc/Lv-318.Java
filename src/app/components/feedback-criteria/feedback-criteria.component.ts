import {Component, OnInit, ViewChild} from '@angular/core';

import {FeedbackCriteria} from '../../models/feedback-criteria.model';
import {FeedbackCriteriaService} from '../../services/feedback-criteria.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-feedback-criteria',
  templateUrl: './feedback-criteria.component.html',
  styleUrls: ['./feedback-criteria.component.css']
})
export class FeedbackCriteriaComponent implements OnInit {

  feedbackCriterias: FeedbackCriteria[];
  displayedColumns = ['id', 'type', 'weight'];
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
