package org.uatransport.service.converter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Range;
import java.util.Objects;
import java.util.stream.Stream;
import lombok.Data;

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

  public boolean existInTimeRange(Integer hour) {
    return Range.closed(this.startHour, this.endHour).contains(hour);
  }

  public boolean isCapacityHoursFeedback() {
    return Stream.of(this.capacity, this.startHour, this.endHour).allMatch(Objects::nonNull);
  }

  // TODO: make inheritance class CapacityStopFeedback extends CapacityFeedback
  public boolean isCapacityStopsFeedback() {
    return Stream.of(this.capacity, this.from, this.to).allMatch(Objects::nonNull);
  }
}
