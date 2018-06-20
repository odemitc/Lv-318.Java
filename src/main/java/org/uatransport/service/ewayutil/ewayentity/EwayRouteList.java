package org.uatransport.service.ewayutil.ewayentity;

import lombok.Data;

import java.io.Serializable;

@Data
public class EwayRouteList  implements Serializable {
    private EwayRoute[] route;
}
