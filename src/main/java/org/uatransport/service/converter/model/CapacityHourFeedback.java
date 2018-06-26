package org.uatransport.service.converter.model;

import com.google.common.collect.Range;
import lombok.Data;

@Data
public class CapacityHourFeedback {
    private static final Integer MINUTES_IN_HOUR = 60;
    private Integer capacity;
    private Time startTime;
    private Time endTime;

    public boolean containsHour(Integer hour) {
        int startPosition = this.startTime.getHour() * MINUTES_IN_HOUR + this.startTime.getMinute();
        int endPositionI = this.endTime.getHour() * MINUTES_IN_HOUR + this.endTime.getMinute();
        //// int countCheckedMinutes = (endPositionInMinutes - startPositionInMinutes) / 2; // 50% of all minutes of
        //// feedback period
        // int counter = 0;
        // int startPositionToCheck = hour * MINUTES_IN_HOUR;
        // int endPositionToCheck = startPositionToCheck + 1;
        // for (int minuteValue = startPositionInMinutes; minuteValue < endPositionInMinutes; minuteValue++) {
        // if (Range.closed(startPositionToCheck, endPositionToCheck).contains(minuteValue)) {
        // counter++;
        // }
        // }
        return (Range.closed(startPosition, endPositionI).contains(hour * MINUTES_IN_HOUR));
    }
}
