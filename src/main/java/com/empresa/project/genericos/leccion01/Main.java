package com.empresa.project.genericos.leccion01;

public class Main {
    public static void main(String[] args) {

        // 1) Sin genéricos: compila, pero falla en ejecución
        BoxObject boxObject = new BoxObject("Hola Gabriel!");
        // Integer n = (Integer) boxObject.getValue(); // lanza ClassCastException

        String text = (String) boxObject.getValue(); // siempre hace falta castear
        System.out.println(text);

        // 2) Con genéricos: el compilador chequea el tipo, sin cast
        Box<String> name = new Box<>("Hola Gabriel!");
        System.out.println(name.getValue());

        // Box<String> wrong = new Box<>(5); // no compila

        Box<Integer> age = new Box<>(30);
        System.out.println(age.getValue());
    }
}
