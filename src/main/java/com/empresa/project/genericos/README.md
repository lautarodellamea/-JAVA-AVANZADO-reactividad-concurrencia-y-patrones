# Genéricos

## ¿Qué son?

Los genéricos permiten escribir una clase o un método **una sola vez** para que funcione con distintos tipos, y hacen que el compilador controle que uses el tipo correcto.

## El problema que resuelven

Sin genéricos, una clase como `BoxObject` guarda un `Object`: acepta cualquier cosa, pero al sacarla hay que castear. Si te equivocás, el error aparece recién al ejecutar (`ClassCastException`).

```java
BoxObject box = new BoxObject("Hola");
Integer n = (Integer) box.getValue(); // compila, pero falla en ejecución
```

Con `Box<T>`, la `T` es un hueco que se completa al usar la clase. Si te equivocás, el error aparece al compilar.

```java
Box<String> box = new Box<>("Hola");
String s = box.getValue();            // sin cast
Box<String> mal = new Box<>(5);       // no compila
```

## En una frase

Un solo código, varios tipos, y los errores se ven antes de ejecutar.
