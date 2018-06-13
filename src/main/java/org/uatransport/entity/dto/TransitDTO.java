package org.uatransport.entity.dto;

import lombok.Data;
import org.uatransport.entity.Stop;

import java.util.List;

@Data
public class TransitDTO {

    private Integer id;
    private String name;
    private Integer categoryId;
    private List<Stop> stops;

}
