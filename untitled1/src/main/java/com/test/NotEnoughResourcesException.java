package com.test;

public class NotEnoughResourcesException extends RuntimeException{
    public NotEnoughResourcesException(String message) {
        super(message);
    }
}
