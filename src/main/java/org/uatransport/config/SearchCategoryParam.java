package org.uatransport.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchCategoryParam {
    private Integer id;
    private String nextLevelCategoryName;
    private String name;
}
