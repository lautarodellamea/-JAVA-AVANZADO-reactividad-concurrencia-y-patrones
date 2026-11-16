package com.empresa.project.genericos.leccion07;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue<T> {
    // Acá usamos la LinkedList de java.util, no la que hicimos en la lección 4
    // El frente de la cola es el primer elemento y el final es el último
    // Se usa LinkedList porque en una cola siempre sacamos del frente:
    // con ArrayList, removeFirst obligaría a correr todos los elementos un lugar (O(n)),
    // en cambio LinkedList solo cambia referencias (O(1))
    // En Java real, para colas se suele preferir ArrayDeque
    private final LinkedList<T> elements = new LinkedList<>();

    // Agrega un elemento al final de la cola
    public void enqueue(T element) {
        elements.addLast(element);
        System.out.println("Elemento agregado " + element);
    }

    // Devuelve el primero de la fila sin sacarlo
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola esta vacía");
        }
        return elements.getFirst();
    }

    // Devuelve el primero de la fila y lo saca
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola esta vacía");
        }
        return elements.removeFirst();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void print() {
        for (T element : elements) {
            System.out.println(element);
        }
    }
}
