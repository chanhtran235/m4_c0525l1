package org.example.demo_spring_data_jpa.exception;

public class DuplicateAdminException extends Exception{
    public DuplicateAdminException(String message) {
        super(message);
    }
}
