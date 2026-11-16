package com.empresa.project.genericos.leccion06;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    // La cima de la pila es el último elemento de la lista
    private final List<T> elements = new ArrayList<>();

    // Agrega un elemento en la cima
    public void push(T element) {
        elements.add(element);
        System.out.println("Elemento agregado... " + element);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Devuelve el elemento de la cima sin sacarlo
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila esta vacía");
        }
        return elements.getLast();
    }

    // Devuelve el elemento de la cima y lo saca
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila esta vacía");
        }
        return elements.removeLast();
    }

    public void print() {
        for (T element : elements) {
            System.out.println(element);
        }
    }
}
