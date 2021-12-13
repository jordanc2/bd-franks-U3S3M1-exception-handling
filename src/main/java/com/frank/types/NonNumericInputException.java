package com.frank.types;

// Custom exception class is a subclass of RuntimeException
public class NonNumericInputException extends RuntimeException {

    // Custom exception class takes two constructors
    // 1 - empty constructor
    // 2 - takes String message and pass super in body
    public NonNumericInputException() {}

    public NonNumericInputException(String aMessage) {
        super(aMessage);
    }
}
