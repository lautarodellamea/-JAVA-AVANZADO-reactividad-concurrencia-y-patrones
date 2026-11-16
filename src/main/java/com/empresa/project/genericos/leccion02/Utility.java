package com.empresa.project.genericos.leccion02;

public class Utility {

    // Método genérico: el <T> va antes del tipo de retorno
    public static <T> void printItem(T value) {
        System.out.println(value);
    }

    // Dos parámetros de tipo distintos: T y K
    public static <T, K> void printItem(T value, K key) {
        System.out.println(value + " " + key);
    }
}
