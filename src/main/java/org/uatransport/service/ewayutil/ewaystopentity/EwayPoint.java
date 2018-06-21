package org.uatransport.service.ewayutil.ewaystopentity;

import lombok.Data;

@Data
public class EwayPoint {
    private double lat;
    private double lng;
    private int direction;
    private String title;
}
