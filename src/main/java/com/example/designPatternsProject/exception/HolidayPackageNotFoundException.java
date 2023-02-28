package com.example.designPatternsProject.exception;

public class HolidayPackageNotFoundException extends RuntimeException {
    public HolidayPackageNotFoundException(String message) {
        super(message);
    }
}
