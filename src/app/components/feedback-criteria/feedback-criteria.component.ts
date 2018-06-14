import { Component, OnInit } from '@angular/core';
import { FeedbackCService } from '../../services/feedbackC.service';

@Component({
  selector: 'app-feedback-criteria',
  templateUrl: './feedback-criteria.component.html',
  styleUrls: ['./feedback-criteria.component.css'],
  providers: [FeedbackCService]
})
export class FeedbackCriteriaComponent implements OnInit {
  feedbackCs: Array<any>;

  constructor(private feedbackCService: FeedbackCService) {
  }

  ngOnInit() {
    this.feedbackCService.getAll().subscribe(
      data => {
        this.feedbackCs = data;
      },
      error => console.log(error)
    );
  }

}
