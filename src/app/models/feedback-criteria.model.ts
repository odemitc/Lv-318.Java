import { Question } from './question.model';

export interface FeedbackCriteria {
  id: number;
  type: string;
  weight: number;
  questions: Question[];
}
