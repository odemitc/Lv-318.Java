import {Component, OnInit} from '@angular/core';
import {Question} from '../../../models/question.model';
import {QuestionService} from '../../../services/question.service';


@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit {

  questions: Question[] = [];

  constructor(private questionService: QuestionService) {
  }

  ngOnInit() {
  }

  addQuestion(groupId: number, name: String): void {
    if (!name) {
      return;
    }
    this.questionService.addQuestion({groupId, name} as Question)
      .subscribe(question => {
        this.questions.push(question);
      });
  }

}
