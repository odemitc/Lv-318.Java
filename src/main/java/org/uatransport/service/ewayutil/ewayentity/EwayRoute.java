package org.uatransport.service.ewayutil.ewayentity;

import lombok.Data;

@Data
public class EwayRoute {
    private Integer id;
    private String title;
    private Integer start_position;
    private Integer stop_position;
    private String transport;
}

