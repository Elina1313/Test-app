package ru.test.test.exception;

public class CounterIdNotFoundException extends RuntimeException {
    public CounterIdNotFoundException(String message) {
        super(message);
    }
}
