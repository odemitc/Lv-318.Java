package org.uatransport.service.converter.model;

import com.google.common.collect.Range;
import lombok.Data;

import java.util.Objects;

@Data
public class CapacityHourFeedback {

    private Integer capacity;
    private Time startTime;
    private Time endTime;

    //    public boolean containsHour(Integer hour) {
//        int minuteValue = hour * 60;
//        int startPositionToCheck = this.startTime.getHour() * 60 + this.startTime.getMinute();
//        int endPositionToCheck = this.endTime.getHour() * 60 + this.endTime.getMinute();
//        return Range.closed(startPositionToCheck, endPositionToCheck).contains(minuteValue);
//    }
    public boolean containsHour(Integer hour) {
        return (Objects.equals(this.startTime.getHour(), this.endTime.getHour())) ?
            containsHourWithEqualsStartEndHours(hour) : containsHourWithDifferentStartEndHours(hour);
    }

    private boolean containsHourWithEqualsStartEndHours(Integer hour) {
        int minuteValue = this.startTime.getHour() * 60 + this.startTime.getMinute();
        int startPositionToCheck = hour * 60;
        int endPositionToCheck = (hour * 60) + 59;
        return Range.closed(startPositionToCheck, endPositionToCheck).contains(minuteValue);
    }

    private boolean containsHourWithDifferentStartEndHours(Integer hour) {
        int startPosition = this.startTime.getHour() * 60 + this.startTime.getMinute();
        int endPosition = this.endTime.getHour() * 60 + this.endTime.getMinute();
        int countCheckedMinutes = (endPosition - startPosition) / 2; //50% of all minutes of feedback period
        int counter = 0;
        int startPositionToCheck = hour * 60;
        int endPositionToCheck = (hour * 60) + 59;
        for (int minuteValue = startPosition; minuteValue <= endPosition; minuteValue++) {
            if (Range.closed(startPositionToCheck, endPositionToCheck).contains(minuteValue)) {
                counter++;
            }
        }

        return counter >= countCheckedMinutes;
    }
}
