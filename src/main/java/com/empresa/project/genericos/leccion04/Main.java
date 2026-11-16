package com.empresa.project.genericos.leccion04;

public class Main {
    public static void main(String[] args) {
        // T = String: la lista solo acepta nombres
        LinkedList<String> list = new LinkedList<>();

        list.add("Ana");
        list.add("Fernando");
        list.add("Andrea");

        list.printList();
    }
}
