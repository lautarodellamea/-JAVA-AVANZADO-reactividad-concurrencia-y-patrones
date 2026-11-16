# Wildcards (comodines)

## ¿Qué son?

El wildcard `?` representa un **tipo desconocido**. Se usa en los parámetros de un método cuando no importa el tipo exacto de la lista que llega.

## Por qué hacen falta

`List<Integer>` **no** es un `List<Number>`, aunque `Integer` sea un `Number`. Si lo fuera, podrías meter un `Double` en una lista de `Integer`. Los wildcards resuelven esto: permiten aceptar varias listas de forma segura.

## Las tres formas

| Forma | Acepta | Podés | No podés |
|-------|--------|-------|----------|
| `List<?>` | Lista de cualquier tipo | Leer como `Object` | Agregar |
| `List<? extends Number>` | `Number` y sus subclases (`Integer`, `Double`...) | Leer como `Number` | Agregar |
| `List<? super Integer>` | `Integer` y sus superclases (`Number`, `Object`) | Agregar `Integer` | Leer algo más específico que `Object` |

## Regla PECS

**P**roducer **E**xtends, **C**onsumer **S**uper.

- Si la lista te **da** datos (la leés): `? extends`.
- Si la lista **recibe** datos (la escribís): `? super`.

## Ejemplo en esta lección

```java
printList(List<?> list)                 // cualquier lista, solo lee
sumNumbers(List<? extends Number> n)    // productor: lee Number
addNumbers(List<? super Integer> n)     // consumidor: agrega Integer
```
