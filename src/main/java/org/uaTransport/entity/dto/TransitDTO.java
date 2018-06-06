package org.uaTransport.entity.dto;

import lombok.Data;
import org.uaTransport.entity.NonExtendableCategory;

@Data
public class TransitDTO {

    private Integer id;
    private String name;
    private NonExtendableCategory category;
}
