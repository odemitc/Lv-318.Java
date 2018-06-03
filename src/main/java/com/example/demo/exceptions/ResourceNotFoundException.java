package com.example.demo.exceptions;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
