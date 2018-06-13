package org.uatransport.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.uatransport.entity.Stop;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class CapacityFeedback {

    @JsonProperty("capacity")
    public Integer capacity;

    @JsonProperty("startHour")
    public Integer startHour;

    @JsonProperty("startMinute")
    public Integer startMinute;

    @JsonProperty("endHour")
    public Integer endHour;

    @JsonProperty("endMinute")
    public Integer endMinute;

    @JsonProperty("from")
    public String from;

    @JsonProperty("to")
    public String to;

    public  boolean existsInTimeRange(Integer time) {
        return IntStream.rangeClosed(this.startHour, this.endHour)
                .boxed()
                .collect(Collectors.toList())
                .contains(time);
    }


}
