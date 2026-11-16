# DataStore genérico

## ¿Qué es?

Un almacén que guarda items y los busca por una clave. Es genérico en **dos tipos**:

- `T`: el tipo del item (por ejemplo `User`).
- `K`: el tipo de la clave (por ejemplo `String`).

```java
DataStore<User, String> userStore = new DataStore<>();
```

## Por qué una lista y un mapa

| Estructura | Para qué |
|------------|----------|
| `List<T>` | Guarda los items en orden |
| `Map<K, T>` | Busca por clave sin recorrer todo |

## Operaciones

- **`add(key, item)`**: devuelve `false` si la clave ya existe y `true` si se agregó. Lanza `NullPointerException` si la clave o el item son nulos (`Objects.requireNonNull`).
- **`find(key)`**: devuelve el item, o `null` si no existe.
- **`remove(key)`**: elimina el item del mapa y de la lista, y lo devuelve (`null` si no existía).
- **`getAll()`**: devuelve la lista con `Collections.unmodifiableList`. Quien la reciba puede leerla pero no modificarla, así el estado interno queda protegido.

## `User`

Clase simple con `id` y `name`, usada como el `T` del ejemplo.
