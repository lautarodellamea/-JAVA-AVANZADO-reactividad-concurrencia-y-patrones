# Stack (pila) genérico

## ¿Qué es?

Una estructura **LIFO** (Last In, First Out): el último en entrar es el primero en salir, como una pila de platos.

```
push(1) → push(2) → push(200)

        cima → [200]
               [ 2 ]
        fondo  [ 1 ]

pop() devuelve 200
```

## Operaciones

| Método | Qué hace |
|--------|----------|
| `push(e)` | Agrega `e` en la cima |
| `pop()` | Saca y devuelve el elemento de la cima |
| `peek()` | Devuelve la cima sin sacarla |
| `isEmpty()` | Dice si la pila está vacía |

`pop()` y `peek()` lanzan `IllegalStateException` si la pila está vacía.

## Por qué es genérica

`Stack<T>` no sabe qué guarda. Se usa como `Stack<Integer>` o `Stack<String>`, y el compilador impide mezclar tipos.

## Ojo

`getLast()` y `removeLast()` de `List` existen desde Java 21.
