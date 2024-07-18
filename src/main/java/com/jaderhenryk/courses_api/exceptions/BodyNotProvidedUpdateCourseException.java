package com.jaderhenryk.courses_api.exceptions;

public class BodyNotProvidedUpdateCourseException extends RuntimeException {
    public BodyNotProvidedUpdateCourseException() {
        super("The request body was not provided.");
    }
}
