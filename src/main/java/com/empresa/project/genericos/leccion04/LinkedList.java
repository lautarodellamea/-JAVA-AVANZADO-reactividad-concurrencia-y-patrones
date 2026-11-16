package com.empresa.project.genericos.leccion04;

public class LinkedList<T> {
    // head apunta al primer nodo; si es null, la lista está vacía
    private Node<T> head;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            // Recorremos hasta el último nodo (el que no tiene next)
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.println("Elemento: " + current.data);
            current = current.next;
        }
    }
}
