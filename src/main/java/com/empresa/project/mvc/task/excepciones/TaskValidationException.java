package com.empresa.project.mvc.task.excepciones;

// Se lanza cuando los datos que llegan a la app no son válidos (vacíos, nulos, etc.)
// Se separa de TaskException, que representa errores de la lógica de negocio
public class TaskValidationException extends Exception {
    public TaskValidationException(String message) {
        super(message);
    }
}
