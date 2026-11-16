package com.empresa.project.mvc;

import com.empresa.project.mvc.task.controller.TaskController;
import com.empresa.project.mvc.task.model.TaskRepository;
import com.empresa.project.mvc.task.view.TaskView;

public class Main {
    public static void main(String[] args) {

        // Se arma de adentro hacia afuera: modelo → controlador → vista
        TaskRepository repository = new TaskRepository();
        TaskController controller = new TaskController(repository);
        TaskView view = new TaskView(controller);

        view.showMenu();
    }
}
