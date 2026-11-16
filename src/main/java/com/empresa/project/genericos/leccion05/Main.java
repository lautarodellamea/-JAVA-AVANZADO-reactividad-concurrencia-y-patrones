package com.empresa.project.genericos.leccion05;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("Ana");
        list.add("Fernando");
        list.add("Andrea");

        System.out.println("Lista inicial:");
        list.printList();

        // update: cambia Fernando por Carlos
        System.out.println("Actualizado: " + list.update("Fernando", "Carlos"));
        list.printList();

        // delete: borra un nodo del medio y después el primero
        System.out.println("Eliminado: " + list.delete("Carlos"));
        System.out.println("Eliminado: " + list.delete("Ana"));
        list.printList();

        // Un dato que no existe devuelve false
        System.out.println("Eliminado: " + list.delete("Pedro"));
    }
}
