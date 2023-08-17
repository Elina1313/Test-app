package ru.test.test.exception;

public class CounterIdNotExistException extends RuntimeException {
    public CounterIdNotExistException(String message) {
        super(message);
    }
}
