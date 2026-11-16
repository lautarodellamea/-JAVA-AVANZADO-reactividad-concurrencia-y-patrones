package com.empresa.project.genericos.leccion01;

// Con genéricos: T se completa cuando se usa la clase.
public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
