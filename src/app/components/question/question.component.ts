import { MatPaginator, MatTableDataSource } from '@angular/material';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Question } from '../../models/question.model';
import { QuestionService } from '../../services/question.service';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {

  questions: Question[];
  displayedColumns = ['id', 'groupId', 'name'];
  dataSource = new MatTableDataSource<Question>();
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private questionService: QuestionService) {
  }

  ngOnInit() {
    this.getAllQuestion();
  }

  getAllQuestion(): void {
    this.questionService.getAllQuestion()
      .subscribe(questions => this.dataSource.data = questions);
    this.dataSource.paginator = this.paginator;
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
  }
}
