package AtiperaTestTask.by.AntonDemchuk.app.config;

import AtiperaTestTask.by.AntonDemchuk.app.dto.ErrorDto;
import AtiperaTestTask.by.AntonDemchuk.app.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerAdviceController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDto> handleNotFound(UserNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto(404, ex.getMessage()));
    }
}
