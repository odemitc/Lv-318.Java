package org.uatransport.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchCategoryParam {
  private Integer id;
  private String firstNestedCategoryName;
  private String secondNestedCategoryName;
  private String name;

  public boolean isEmpty() {
    return id == null
            && firstNestedCategoryName == null
            && secondNestedCategoryName == null
            && name == null;
  }
}
