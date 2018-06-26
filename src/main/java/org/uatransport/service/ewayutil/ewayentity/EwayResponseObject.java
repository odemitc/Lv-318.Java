package org.uatransport.service.ewayutil.ewayentity;

import lombok.Data;

import java.io.Serializable;

@Data
public class EwayResponseObject implements Serializable {
    private EwayRouteList routesList;
}
