package com.example.demo.controller;

import com.example.demo.entity.DTO.NonExtendableCategoryDTO;
import com.example.demo.entity.NonExtendableCategory;
import com.example.demo.service.NonExtendableCategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/NonExtendableCategory")
@RequiredArgsConstructor
public class NonExtendableCategoryController {
    private final NonExtendableCategoryService nonExtendableCategoryService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping
    public ResponseEntity<List<NonExtendableCategory>> getCategoryByNextLevel(@RequestParam String up) {
        List<NonExtendableCategory> categories = nonExtendableCategoryService.getByNextLevelCategory(nonExtendableCategoryService.getByName(up).getId());

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


//    @GetMapping("/b/{id}")
//    public ResponseEntity<NonExtendableCategory> getCategoryById(@PathVariable Integer id) {
//
//        NonExtendableCategory category = nonExtendableCategoryService.getById(id);
//
//        return new ResponseEntity<>(category, HttpStatus.OK);
//
//    }
//
//    @GetMapping("/a/{id}")
//    public ResponseEntity<String> getCategoryById(@PathVariable Integer id) throws JsonProcessingException {
//        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
//        NonExtendableCategory category = nonExtendableCategoryService.getById(id);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .replacePath("/category/{id}")
//                .buildAndExpand(category.getNextLevelCategory().getId())
//                .toUri();
//        String linkAsJson = objectMapper.writeValueAsString(Collections.singletonMap("linkToUpperCategory",location));
//        String json = objectMapper.writeValueAsString(category).concat(linkAsJson);
//        System.out.print(location.toString());
//        return ResponseEntity.ok().body(json);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<NonExtendableCategoryDTO> getCategoryById(@PathVariable Integer id) {

        return new ResponseEntity<>(nonExtendableCategoryService.getByIdDTO(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<NonExtendableCategory> addCategory(@RequestBody NonExtendableCategory nonExtendableCategory) {

        NonExtendableCategory category = nonExtendableCategoryService.addNonExtendableCategory(nonExtendableCategory);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        nonExtendableCategoryService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<NonExtendableCategory> updateCategory(@RequestParam NonExtendableCategory nonExtendableCategory, @PathVariable Integer id) {
        NonExtendableCategory updatedCategory = nonExtendableCategoryService.update((NonExtendableCategory) nonExtendableCategory.setId(id));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(updatedCategory.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    //TODO take care about feedbackCriterias and chose one of getCategoryById methods
}
