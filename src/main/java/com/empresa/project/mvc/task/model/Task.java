package com.empresa.project.mvc.task.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Modelo: representa una tarea. No sabe nada de la vista ni del controlador
// Lombok genera en compilación el código repetitivo que antes escribíamos a mano
@Getter                                             // getId(), getTitle(), getDescription(), getCompleted()
@Setter                                             // setId(), setTitle(), setDescription(), setCompleted()
@AllArgsConstructor                                 // constructor con todos los campos, en el orden declarado
@ToString                                           // toString() con todos los campos
@EqualsAndHashCode(onlyExplicitlyIncluded = true)   // equals() y hashCode() solo con los campos marcados
public class Task {

    // Dos tareas son iguales si tienen el mismo id (lo usa tasks.contains(task))
    @EqualsAndHashCode.Include
    private String id;
    private String title;
    private String description;
    private Boolean completed;
}
