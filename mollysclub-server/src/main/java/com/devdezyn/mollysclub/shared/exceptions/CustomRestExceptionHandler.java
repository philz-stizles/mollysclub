package com.devdezyn.mollysclub.shared.exceptions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.devdezyn.mollysclub.shared.ApiResponseBody;
import com.devdezyn.mollysclub.shared.errors.ApiError;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
    MethodArgumentNotValidException ex, 
    HttpHeaders headers, 
    HttpStatus status, 
    WebRequest request
  ) {
    List<String> errors = new ArrayList<String>();
    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
      errors.add(error.getField() + ": " + error.getDefaultMessage());
    }
    for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
      errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
    }

    log.error(ex.getLocalizedMessage());

    ApiError apiError = new ApiError(false, HttpStatus.BAD_REQUEST.toString(), errors);
    return handleExceptionInternal(ex, apiError, headers, HttpStatus.BAD_REQUEST, request);
    // Map<String, Object> body = new LinkedHashMap<>();
    //     body.put("timestamp", new Date());
    //     body.put("status", status.value());

    //     //Get all errors
    //     List<String> errors = ex.getBindingResult()
    //             .getFieldErrors()
    //             .stream()
    //             .map(x -> x.getDefaultMessage())
    //             .collect(Collectors.toList());

    //     body.put("errors", errors);

    //     return new ResponseEntity<>(body, headers, status);
  }
  
  @ExceptionHandler({ ConstraintViolationException.class })
  public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
      List<String> errors = new ArrayList<String>();
      for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
          errors.add(violation.getRootBeanClass().getName() + " " + 
            violation.getPropertyPath() + ": " + violation.getMessage());
      }

      return ResponseEntity.badRequest().body(new ApiError(false, HttpStatus.BAD_REQUEST.toString(), errors));
  }
    
  // Catch file size exceeded exception!
  @ExceptionHandler(MultipartException.class)
  @ResponseBody
  ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {

    HttpStatus status = getStatus(request);
    return new ResponseEntity<>(ex.getMessage(), status);

    // example
    //return new ResponseEntity("success", responseHeaders, HttpStatus.OK);

  }

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public ResponseEntity<ApiResponseBody<?>> handleMaxSizeException(MaxUploadSizeExceededException exc) {
    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ApiResponseBody<>(false, "File too large!"));
  }
    
  private HttpStatus getStatus(HttpServletRequest request) {
    Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
    if (statusCode == null) {
      return HttpStatus.INTERNAL_SERVER_ERROR;
    }
    return HttpStatus.valueOf(statusCode);
  }

  @Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
    HttpRequestMethodNotSupportedException ex, 
    HttpHeaders headers, 
    HttpStatus status, 
    WebRequest request
  ) {
    StringBuilder builder = new StringBuilder();
    builder.append(ex.getMethod());
    builder.append(" method is not supported for this request. Supported methods are ");
    ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

    ApiError apiError = new ApiError(false, HttpStatus.METHOD_NOT_ALLOWED.toString(), builder.toString());
    return ResponseEntity.badRequest().headers(new HttpHeaders()).body(apiError);
  }
  
  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
    HttpMediaTypeNotSupportedException ex, 
    HttpHeaders headers, 
    HttpStatus status, 
    WebRequest request
  ) {
    StringBuilder builder = new StringBuilder();
    builder.append(ex.getContentType());
    builder.append(" media type is not supported. Supported media types are ");
    ex.getSupportedMediaTypes().forEach(t -> builder.append(t + ", "));

    ApiError apiError = new ApiError(false, HttpStatus.UNSUPPORTED_MEDIA_TYPE.toString(),
        builder.substring(0, builder.length() - 2));
    return ResponseEntity.badRequest().headers(new HttpHeaders()).body(apiError);
  }
  
  @ExceptionHandler({ Exception.class })
  public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
    log.error(ex.getLocalizedMessage(), ex);
      ApiError apiError = new ApiError(false, HttpStatus.INTERNAL_SERVER_ERROR.toString(), "error occurred");
      return ResponseEntity.internalServerError().headers(new HttpHeaders()).body(apiError);
  }
}
