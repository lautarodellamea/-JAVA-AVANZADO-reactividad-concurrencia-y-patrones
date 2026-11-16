# LinkedList personalizada, parte 2

Se suman tres operaciones a la lista de la lección anterior: recorrer, actualizar y eliminar.

## Recorrer (`printList`)

Empieza en `head` y avanza con `current = current.next` hasta que `current` sea `null`. Todas las demás operaciones usan este mismo patrón.

## Actualizar (`update`)

Recorre hasta encontrar el nodo con `oldValue` y le cambia el `data`. Los nodos no se mueven, solo cambia el dato. Devuelve `false` si no lo encuentra.

## Eliminar (`delete`)

Hay dos casos:

1. **El dato está en el primer nodo:** `head` pasa a apuntar a `head.next`.
2. **El dato está en otro lugar:** nos paramos en el nodo *anterior* al que queremos borrar y hacemos `current.next = current.next.next`. El nodo borrado queda sin referencias.

```
Antes:   [Ana] → [Carlos] → [Andrea]
delete("Carlos")
Después: [Ana] ───────────→ [Andrea]
```

## ¿Por qué `Objects.equals` y no `==`?

`==` compara referencias, no contenido. Con `String` o `Integer` puede dar `false` aunque el valor sea igual. `Objects.equals` usa `equals()` y además tolera `null`.
