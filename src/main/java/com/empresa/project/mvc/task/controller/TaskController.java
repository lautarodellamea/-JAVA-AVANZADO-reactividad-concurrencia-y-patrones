package com.empresa.project.mvc.task.controller;

import com.empresa.project.mvc.task.excepciones.TaskException;
import com.empresa.project.mvc.task.excepciones.TaskValidationException;
import com.empresa.project.mvc.task.model.Task;
import com.empresa.project.mvc.task.model.TaskRepository;

import java.util.List;

// Controlador: valida los datos que llegan, usa el modelo y muestra el resultado
public class TaskController {
    // El repositorio llega por el constructor (inyección de dependencias)
    // De tipo final para que nos exija asignacion y evitar que sea reasignado a otro objeto una vez que lo asignemos, esto garantiza que la referencia al repositorio no cambie durante la vida util del controlador (inmutabilidad)
    // claridad: indica a otros devs del equipo que es una dependencia escencial y constante para el controlador
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(String id, String title, String description, Boolean completed) throws TaskValidationException, TaskException {
        validateTaskData(id, title, description, completed);
        Task task = new Task(id, title, description, completed);
        this.taskRepository.save(task);
        System.out.println("La tarea fue agregada exitosamente.");
    }

    public void removeTask(String id) throws TaskValidationException, TaskException {
        if (id == null || id.trim().isEmpty()) {
            throw new TaskValidationException("El id no puede estar vacío");
        }
        this.taskRepository.remove(id);
    }

    public void showTasks() throws TaskValidationException, TaskException {
        List<Task> tasks = this.taskRepository.findAll();
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void showCompletedTasks() throws TaskValidationException, TaskException {
        List<Task> completedTasks = this.taskRepository.findCompletedTasks();

        for (Task task : completedTasks) {
            System.out.println(task);
        }
    }

    public void showPendingTasks() throws TaskValidationException, TaskException {
        List<Task> pendingTasks = this.taskRepository.findPendingTasks();

        for (Task task : pendingTasks) {
            System.out.println(task);
        }
    }

    public void updateTask(String id, String title, String description, Boolean completed) throws TaskValidationException, TaskException {
        validateTaskData(id, title, description, completed);
        Task updateTask = new Task(id, title, description, completed);
        this.taskRepository.updateTask(updateTask);
    }

    public void updateTaskCompleted(String id, Boolean completed) throws TaskValidationException, TaskException {
        validateTaskData(id, completed);
        this.taskRepository.updateTaskCompleted(id, completed);
    }

    // Sobrecarga: una validación completa y otra solo con id y estado
    private void validateTaskData(String id, String title, String description, Boolean completed) throws TaskValidationException {
        if (id == null || id.trim().isEmpty()) {
            throw new TaskValidationException("El id no puede estar vacío");
        }

        if (title == null || title.trim().isEmpty()) {
            throw new TaskValidationException("El título no puede estar vacío");
        }

        if (description == null || description.trim().isEmpty()) {
            throw new TaskValidationException("La descripción no puede estar vacía");
        }

        if (completed == null) {
            throw new TaskValidationException("El estado no puede ser nulo");
        }
    }

    private void validateTaskData(String id, Boolean completed) throws TaskValidationException {
        if (id == null || id.trim().isEmpty()) {
            throw new TaskValidationException("El id no puede estar vacío");
        }

        if (completed == null) {
            throw new TaskValidationException("El estado no puede ser nulo");
        }
    }
}
