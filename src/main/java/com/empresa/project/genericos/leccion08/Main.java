package com.empresa.project.genericos.leccion08;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // T = User, K = String: guardamos usuarios y los buscamos por id
        DataStore<User, String> userStore = new DataStore<>();

        try {
            System.out.println("Añadiendo usuarios...");
            userStore.add("123", new User("123", "Fernando"));
            userStore.add("1234", new User("1234", "María"));

            // Clave repetida: no se agrega y devuelve false
            System.out.println("Clave repetida: " + userStore.add("123", new User("123", "Otro")));

            System.out.println("Encontrado: " + userStore.find("123"));
            System.out.println("No existe: " + userStore.find("999"));

            System.out.println("Eliminado: " + userStore.remove("123"));
            System.out.println("Eliminado (no existe): " + userStore.remove("123"));

            // Clave nula: lanza NullPointerException con nuestro mensaje
            userStore.add(null, new User("12345", "Ana"));

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        // getAll devuelve la lista de solo lectura
        List<User> users = userStore.getAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
