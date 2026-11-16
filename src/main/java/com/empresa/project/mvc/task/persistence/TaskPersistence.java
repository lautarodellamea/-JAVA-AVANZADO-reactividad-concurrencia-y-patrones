package com.empresa.project.mvc.task.persistence;

import com.empresa.project.mvc.task.model.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

// Guarda y lee las tareas en un archivo JSON usando Gson
public class TaskPersistence {
    // Ruta relativa: el archivo se crea en la carpeta desde donde se ejecuta la app
    private static final String FILE_PATH = "tasks.json";
    // setPrettyPrinting hace que el JSON quede indentado y legible
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Convierte la lista a JSON y la escribe en el archivo (lo reemplaza completo)
    public static void saveTasks(List<Task> tasks) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static List<Task> loadTasks() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (Reader reader = new FileReader(FILE_PATH)) {
            // Por el type erasure, List<Task>.class no existe: TypeToken guarda el tipo completo
            Type listType = new TypeToken<List<Task>>() {}.getType();
            List<Task> tasks = gson.fromJson(reader, listType);
            // Si el archivo está vacío, fromJson devuelve null
            return tasks != null ? tasks : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
