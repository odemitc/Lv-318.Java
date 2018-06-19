package org.uatransport.entity.dto;

import java.util.List;
import lombok.Data;
import org.uatransport.entity.Stop;

@Data
public class TransitDTO {

  private Integer id;
  private String name;
  private Integer categoryId;
  private List<Stop> stops;
}
