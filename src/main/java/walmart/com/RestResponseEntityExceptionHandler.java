package walmart.com;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = { NotFoundException.class })
  protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
    String bodyOfResponse = "{\"error\": \"Not Found\"}";
    return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }
  
  @ExceptionHandler(value = { SystemException.class })
  protected ResponseEntity<Object> handleSystemException(RuntimeException ex, WebRequest request) {
    String bodyOfResponse = "{\"error\": \"Not Found\"}";
    return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
  }
}
