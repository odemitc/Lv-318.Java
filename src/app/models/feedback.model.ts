import { Question } from './question.model';
import { Stop } from './stop.model';

export class Feedback{
    answer: string ;
    userId: number ;
    transitId: number ;
    criteriaId: number ;
    questions: String[];
    type : String;
    capacityAnswer: CapacityAnswer;
    accepterOrRateAnswer : Answer;

   
}
export class Answer{
    value: string;
}

export class CapacityAnswer{
    from: Stop ;
    to: Stop ;
    capacity: number ;
    startTime: Time;
    endTime: Time;

    toCapacityHoursString():string{
        const answer ='';
        return this.startTime.toString()+this.endTime.toString()+this.capacity.toString();
    }
    toCapacityRouteString():string{
        const answer ='';
        return  this.from.toString()+this.endTime.toString()+this.capacity.toString();
    }
}

export class Time{
    hour: number;
    minute: number;
}