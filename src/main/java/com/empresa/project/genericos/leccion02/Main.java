package com.empresa.project.genericos.leccion02;

public class Main {
    public static void main(String[] args) {

        // T se infiere según lo que le pasemos
        Utility.printItem(10);
        Utility.printItem("Gabriel", "2");

        // Con Integer y con Double: ambos son Number
        System.out.println(MathUtils.sum(2, 4));
        System.out.println(MathUtils.sum(2.5, 1.5));

        // MathUtils.sum("a", "b"); // no compila: String no es Number
    }
}
