package com.empresa.project.genericos.leccion05;

import java.util.Objects;

public class LinkedList<T> {
    // head apunta al primer nodo; si es null, la lista está vacía
    private Node<T> head;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Recorre la lista desde head hasta que current sea null
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.println("Elemento: " + current.data);
            current = current.next;
        }
    }

    // Busca el primer nodo con oldValue y le cambia el dato por newValue
    // Devuelve false si no lo encuentra
    public boolean update(T oldValue, T newValue) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.data, oldValue)) {
                current.data = newValue;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Elimina el primer nodo que tenga ese dato
    // Devuelve false si no lo encuentra
    public boolean delete(T data) {
        if (head == null) {
            return false;
        }

        // Caso especial: el dato está en el primer nodo, head pasa al siguiente
        if (Objects.equals(head.data, data)) {
            head = head.next;
            return true;
        }

        // Caso general: nos paramos en el nodo anterior al que queremos borrar
        // y lo "saltamos" apuntando su next al siguiente del borrado
        Node<T> current = head;
        while (current.next != null) {
            if (Objects.equals(current.next.data, data)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
