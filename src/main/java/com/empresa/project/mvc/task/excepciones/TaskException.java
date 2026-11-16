package com.empresa.project.mvc.task.excepciones;

// Excepción chequeada (extiende Exception): obliga a quien la use a manejarla
public class TaskException extends Exception {
    public TaskException(String message) {
        super(message);
    }
}
