package com.example.demo.entity.dto;

import com.example.demo.entity.NonExtendableCategory;
import lombok.Data;

@Data
public class TransitDTO {

    private Integer id;
    private String name;
    private NonExtendableCategory category;
}
