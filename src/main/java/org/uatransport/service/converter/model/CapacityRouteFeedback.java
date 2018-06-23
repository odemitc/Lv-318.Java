package org.uatransport.service.converter.model;

import lombok.Data;
import org.uatransport.entity.Stop;

@Data
public class CapacityRouteFeedback {

    private Stop from;
    private Stop to;
    private Integer capacity;

}
