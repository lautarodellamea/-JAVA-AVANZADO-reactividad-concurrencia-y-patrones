# LinkedList personalizada

## ¿Qué es una lista enlazada?

Una estructura donde cada elemento (nodo) guarda su dato y una referencia al siguiente. No hay índices: para llegar a un elemento hay que recorrer desde el primero.

```
head → [Ana | •] → [Fernando | •] → [Andrea | null]
```

## Por qué es genérica

`Node<T>` y `LinkedList<T>` no saben qué guardan. El tipo se decide al usarla: `LinkedList<String>`, `LinkedList<Integer>`, etc. Con un solo código sirve para cualquier tipo.

## Piezas

- **`Node<T>`**: guarda `data` y `next`.
- **`LinkedList<T>`**: guarda `head` (el primer nodo).
- **`add`**: si la lista está vacía, el nuevo nodo es `head`. Si no, recorre hasta el último nodo y lo enlaza.
- **`printList`**: recorre desde `head` hasta que `current` sea `null`.

## Ojo

Esta `LinkedList` es la nuestra, no la de `java.util`. Cuidá los imports.
