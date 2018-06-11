package org.uatransport.entity.dto;

import lombok.Data;
import org.uatransport.entity.NonExtendableCategory;

@Data
public class TransitDTO {

    private Integer id;
    private String name;
    private NonExtendableCategory category;
}
