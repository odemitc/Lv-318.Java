package org.uatransport.entity.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@RequiredArgsConstructor
public class NonExtendableCategoryDto {
    private String name;
    private Integer nextLevelCategory;
    private List<Integer> feedbackCriterias;
}
