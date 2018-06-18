package org.uatransport.entity.dto;

import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@RequiredArgsConstructor
public class NonExtendableCategoryDto {
  private String name;
  private Integer nextLevelCategory;
  private List<Integer> feedbackCriterias;
}
