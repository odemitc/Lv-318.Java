package org.uatransport.service.converter.model;

import lombok.Data;
import org.uatransport.entity.Stop;


@Data
public class CapacityRouteFeedback {

    public Stop from;

    public Stop to;

    public Integer capacity;

}
