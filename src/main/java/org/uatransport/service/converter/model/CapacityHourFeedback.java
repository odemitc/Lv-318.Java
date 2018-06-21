package org.uatransport.service.converter.model;

import com.google.common.collect.Range;
import lombok.Data;

@Data
public class CapacityHourFeedback {

    private Integer capacity;
    private Time startTime;
    private Time endTime;

    public boolean containsHour(Integer hour) {
        int minuteValue = hour * 60;
        int startPositionToCheck = this.startTime.getHour() * 60 + this.startTime.getMinute();
        int endPositionToCheck = this.endTime.getHour() * 60 + this.endTime.getMinute();
        return Range.closed(startPositionToCheck, endPositionToCheck).contains(minuteValue);
    }

}
