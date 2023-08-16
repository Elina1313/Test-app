package ru.test.test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.test.test.exception.CounterIdNotFoundException;
import ru.test.test.model.ErrorResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class ExceptionHandler {
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleUserNotExistException(final CounterIdNotFoundException exception) {
        return new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.getReasonPhrase().toUpperCase(),
                LocalDateTime.now().format(dateFormatter));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseBody
    public ErrorResponse handleCounterIDAndIncrementCountMismatchException(final CounterIDAndIncrementCountMismatchException exception) {
        return new ErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase().toUpperCase(),
                LocalDateTime.now().format(dateFormatter));
    }
}
