package com.empresa.project.genericos.leccion02;

public class MathUtils {

    // Restricción: T solo puede ser Number o una subclase (Integer, Double, etc.)
    // Gracias a eso podemos usar doubleValue(), que Object no tiene
    public static <T extends Number> double sum(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
}
