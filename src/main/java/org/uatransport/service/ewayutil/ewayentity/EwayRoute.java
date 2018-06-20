package org.uatransport.service.ewayutil.ewayentity;

import lombok.Data;

import java.io.Serializable;

@Data
public class EwayRoute implements Serializable {
    private Integer id;
    private String title;
    private Integer start_position;
    private Integer stop_position;
    private String transport;
}

