package com.empresa.project.genericos.leccion04;

// Un nodo guarda un dato de tipo T y una referencia al siguiente nodo
public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null; // al crearlo todavía no apunta a nadie
    }
}
