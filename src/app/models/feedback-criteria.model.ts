import {Question} from './question.model';
export class FeedbackCriteria {
  id: number;
  type: string;
  weight: number;
  questions: Question [];
}
