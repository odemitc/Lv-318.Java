package org.uaTransport.entity.dto;

import org.uaTransport.entity.NonExtendableCategory;
import lombok.Data;

@Data
public class TransitDTO {

    private Integer id;
    private String name;
    private NonExtendableCategory category;
}
