package com.example.demo.config;

import com.example.demo.exceptions.ResourceNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

//    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
//        return new ResponseEntity<>(apiError, apiError.getStatus());
//    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleConflict(final ResourceNotFoundException ex, final WebRequest request) {
        final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }


//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    @NotNull
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NotNull MethodArgumentNotValidException ex,
//                                                                  @NotNull HttpHeaders headers,
//                                                                  @NotNull HttpStatus status,
//                                                                  @NotNull WebRequest request) {
//        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
//        apiError.setMessage("Validation error");
//        apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
//        apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
//        return buildResponseEntity(apiError);
//    }
//
//    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
//    protected ResponseEntity<Object> handleConstraintViolation(
//            javax.validation.ConstraintViolationException ex) {
//        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
//        apiError.setMessage("Validation error");
//        apiError.addValidationErrors(ex.getConstraintViolations());
//        return buildResponseEntity(apiError);
//    }
//
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
//                                                                      WebRequest request) {
//        Class<?> requiredType = ex.getRequiredType();
//        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
//        apiError.setMessage(String.format("The parameter '%s' of value '%s' could not be converted to type '%s'",
//                ex.getName(), ex.getValue(),  requiredType != null ? requiredType.getName() : "of the argument"));
//        apiError.setDebugMessage(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }
}