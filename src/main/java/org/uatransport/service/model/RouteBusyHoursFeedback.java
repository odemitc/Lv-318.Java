package org.uatransport.service.model;

import org.uatransport.entity.Stop;

import java.time.LocalDateTime;

public class RouteBusyHoursFeedback {
    public Stop from;
    public Stop to;
    public LocalDateTime start;
    public LocalDateTime end;
}
