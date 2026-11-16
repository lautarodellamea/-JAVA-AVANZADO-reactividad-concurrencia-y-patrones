# Queue (cola) genérica

## ¿Qué es?

Una estructura **FIFO** (First In, First Out): el primero en entrar es el primero en salir, como la fila de una caja.

```
enqueue(10) → enqueue(20) → enqueue(30)

frente → [10] [20] [30] ← final

dequeue() devuelve 10
```

## Operaciones

| Método | Qué hace |
|--------|----------|
| `enqueue(e)` | Agrega `e` al final |
| `dequeue()` | Saca y devuelve el primero |
| `peek()` | Devuelve el primero sin sacarlo |
| `isEmpty()` | Dice si la cola está vacía |

`dequeue()` y `peek()` lanzan `NoSuchElementException` si la cola está vacía.

## Stack vs Queue

| | Stack | Queue |
|---|---|---|
| Orden | LIFO | FIFO |
| Agrega | en la cima | al final |
| Saca | de la cima | del frente |

## Ojo

Esta clase usa internamente la `LinkedList` de `java.util` (con `addLast`, `getFirst` y `removeFirst`), no la que hicimos en la lección 4.
