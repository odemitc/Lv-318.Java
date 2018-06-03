package com.example.demo.entity.DTO;

import com.example.demo.entity.NonExtendableCategory;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Data
@Accessors(chain = true)
public class NonExtendableCategoryDTO {
    private Integer id;
    private String name;
    private URI linkToUpperCategory;

    public NonExtendableCategoryDTO(NonExtendableCategory nonExtendableCategory) {

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/category/{id}")
                .buildAndExpand(nonExtendableCategory.getNextLevelCategory().getId())
                .toUri();

        this.setId(nonExtendableCategory.getId())
                .setName(nonExtendableCategory.getName())
                .setLinkToUpperCategory(location);
    }
}
