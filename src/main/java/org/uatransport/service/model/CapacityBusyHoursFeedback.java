package org.uatransport.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CapacityBusyHoursFeedback {

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

}
