package org.uatransport.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

  public boolean existsInTimeRange(Integer time) {
    return IntStream.rangeClosed(this.startHour, this.endHour)
        .boxed()
        .collect(Collectors.toList())
        .contains(time);
  }

  public boolean isCapacityHoursFeedback() {
    return Stream.of(this.capacity, this.startHour, this.endHour).allMatch(Objects::nonNull);
  }

  public boolean isCapacityStopsFeedback() {
    return Stream.of(this.capacity, this.from, this.to).allMatch(Objects::nonNull);
  }
}
