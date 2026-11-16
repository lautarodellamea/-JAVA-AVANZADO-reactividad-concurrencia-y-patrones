package com.empresa.project.genericos.leccion03;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Gabriel");
        names.add("María");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        // List<?> acepta una lista de cualquier tipo
        printList(numbers);
        printList(names);

        // List<? extends Number> acepta Integer, Double, etc.
        sumNumbers(numbers);

        // List<? super Integer> acepta Integer, Number u Object
        addNumbers(numbers);
    }

    // Comodín sin límite: solo sirve para leer como Object, no me permite
    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    // Productor (extends): la lista nos da datos, podemos leer como Number
    // pero no agregar, porque no sabemos si es de Integer o de Double
    public static void sumNumbers(List<? extends Number> numbers) {
        double sum = 0;
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        System.out.println(sum);
    }

    // Consumidor (super): la lista recibe datos, podemos agregar Integer
    // pero al leer solo tenemos la garantía de que es un Object
    public static void addNumbers(List<? super Integer> numbers) {
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        Object num = numbers.get(0);
        System.out.println(num);
    }
}
