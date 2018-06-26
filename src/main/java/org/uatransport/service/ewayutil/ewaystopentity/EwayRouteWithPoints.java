package org.uatransport.service.ewayutil.ewaystopentity;

import lombok.Data;

@Data
public class EwayRouteWithPoints {
    private String title;
    private String type;
    private EwayPoints points;
}
