package com.empresa.project.genericos.leccion06;

public class Main {
    public static void main(String[] args) {
        // La misma clase sirve para Integer y para String
        Stack<Integer> integerStack = new Stack<>();

        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(200);

        Stack<String> names = new Stack<>();
        names.push("Gabriel");
        names.push("Fernando");

        integerStack.print();

        System.out.println("Elemento en la cima " + integerStack.peek());

        // pop saca el último que entró (200)
        System.out.println("Eliminar un elemento " + integerStack.pop());

        integerStack.print();
    }
}
