# Genéricos: preguntas de entrevista y uso en el trabajo

## Preguntas de entrevista

### 1. ¿Qué es el type erasure?

El compilador usa los tipos genéricos para chequear el código y después los **borra**: en el bytecode `T` pasa a ser `Object` (o su límite, si hay `extends`) y se insertan los casts necesarios. En ejecución, `List<String>` y `List<Integer>` son la misma clase `List`.

Consecuencias, todas dan error de compilación:

- `new T()`
- `new T[10]`
- `obj instanceof List<String>`
- Dos métodos que solo difieren en el genérico (`m(List<String>)` y `m(List<Integer>)`) chocan.

Se hizo así por compatibilidad con el código anterior a Java 5.

### 2. ¿Por qué `List<Integer>` no es un `List<Number>`?

Por **invarianza**. Si lo fuera, esto compilaría:

```java
List<Integer> ints = new ArrayList<>();
List<Number> nums = ints;   // supongamos que se permite
nums.add(1.5);              // un Double dentro de una lista de Integer
```

Los arrays sí son covariantes (`Integer[]` es un `Number[]`), y ese mismo error falla recién en ejecución con `ArrayStoreException`. Los genéricos lo evitan en compilación.

### 3. ¿Qué es PECS?

**P**roducer **E**xtends, **C**onsumer **S**uper.

- La lista te **da** datos (la leés): `List<? extends Number>`. Leés como `Number`, no podés agregar.
- La lista **recibe** datos (la escribís): `List<? super Integer>`. Agregás `Integer`, al leer solo obtenés `Object`.
- Si hacés las dos cosas, usá el tipo exacto (`List<T>`).

### 4. ¿Qué diferencia hay entre `<T extends Number>` y `List<? extends Number>`?

- `<T extends Number>` le **pone nombre** al tipo. Podés relacionar parámetros y retorno: `<T extends Number> T max(T a, T b)` obliga a que `a`, `b` y el resultado sean del mismo tipo.
- `?` es un tipo desconocido **sin nombre**. No podés relacionarlo con nada más.

Regla práctica: si el tipo aparece una sola vez en la firma, usá wildcard. Si lo necesitás en más de un lugar, usá `T`.

### 5. Eliminar un nodo de una lista enlazada

Hay dos casos:

```java
public boolean delete(T data) {
    if (head == null) return false;

    // Caso 1: el dato está en el primer nodo
    if (Objects.equals(head.data, data)) {
        head = head.next;
        return true;
    }

    // Caso 2: nos paramos en el nodo anterior y lo saltamos
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
```

Lo que suelen mirar: el caso de `head`, el caso de lista vacía y no perder la referencia al resto de la lista.

### 6. ¿`ArrayList` o `LinkedList`?

| Operación | `ArrayList` | `LinkedList` |
|-----------|-------------|--------------|
| `get(i)` | O(1) | O(n) |
| Agregar al final | O(1) amortizado | O(1) |
| Sacar el primero | O(n) | O(1) |

En la práctica `ArrayList` casi siempre gana (menos memoria, mejor uso de caché). Para pilas y colas, lo recomendado en Java es **`ArrayDeque`**. Nuestra `Queue` usa `LinkedList` porque se saca siempre del frente.

### 7. ¿Qué es LIFO y qué es FIFO?

- **LIFO** (Last In, First Out): pila (`Stack`). Sale el último que entró.
- **FIFO** (First In, First Out): cola (`Queue`). Sale el primero que entró.

### 8. ¿`==` o `equals`?

`==` compara **referencias**, `equals` compara **contenido**. Con `String` e `Integer`, `==` puede dar `false` aunque el valor sea igual (el caché de `Integer` solo cubre -128 a 127). `Objects.equals(a, b)` usa `equals` y además tolera `null`, por eso lo usamos en `update` y `delete`.

### Extra: ¿qué es un tipo crudo (raw type)?

Usar una clase genérica sin su tipo (`List` en vez de `List<String>`). Se pierde el chequeo del compilador y vuelven los `ClassCastException` en ejecución. Existe solo por compatibilidad: **no se usa**.

---

## Uso en el trabajo del día a día

1. **Siempre con tipo en las colecciones**: `List<String>`, nunca `List` a secas.
2. **Wildcards en los parámetros**: si un método solo lee, recibí `List<? extends X>` y aceptará más listas.
3. **Defensive copy**: devolvé `Collections.unmodifiableList(...)` o `List.copyOf(...)` para no exponer tu estado interno. La primera es una vista (refleja los cambios de la original), la segunda es una copia independiente.
4. **`Objects.requireNonNull`** para fallar rápido con un mensaje claro.
5. **Utilidades genéricas con restricción**: `<T extends Comparable<T>>` para escribir un método que sirva para cualquier tipo comparable.

> No vas a escribir tu propia `LinkedList`, `Stack` o `Queue` en el trabajo: se usan las de Java. Se estudian para entender cómo funcionan por dentro y para las entrevistas.
