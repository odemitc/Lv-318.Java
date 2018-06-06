package org.uaTransport.exception;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
