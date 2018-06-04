package com.example.demo.entity.DTO;

import com.example.demo.entity.NonExtendableCategory;
import lombok.Data;
import lombok.experimental.Accessors;

import java.net.URI;

@Data
@Accessors(chain = true)
public class NonExtendableCategoryDTO {
    private Integer id;
    private String name;
    private URI linkToUpperCategory;

    public NonExtendableCategoryDTO(NonExtendableCategory nonExtendableCategory) {
        this.setId(nonExtendableCategory.getId()).setName(nonExtendableCategory.getName());
    }
}
