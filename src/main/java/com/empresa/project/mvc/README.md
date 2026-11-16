# Patrón MVC: app de tareas

## ¿Qué es MVC?

Separar una aplicación en tres capas, cada una con una sola responsabilidad:

| Capa | Responsabilidad | En esta app |
|------|-----------------|-------------|
| **Modelo** | Los datos y las reglas de negocio | `Task`, `TaskRepository` |
| **Vista** | Mostrar información y leer lo que escribe el usuario | `TaskView` |
| **Controlador** | Conectar las dos: recibe la acción, usa el modelo y le pide a la vista que muestre el resultado | `TaskController` |

La vista y el modelo **no se conocen entre sí**. Solo el controlador habla con los dos. Así podés cambiar la consola por una web sin tocar el modelo.

## Estructura

La app crece lección a lección dentro de `task/`, en una sola copia:

```
task/
  model/         Task, TaskRepository
  excepciones/   TaskException, TaskValidationException
  view/          TaskView
  controller/    TaskController
  persistence/   TaskPersistence (Gson)
```

## Cómo se construyó, paso a paso

Si querés reconstruir la app desde cero (o saber por dónde empezar en un proyecto MVC nuevo), este es el orden en que se desarrolló. Se va de adentro hacia afuera: primero lo que no depende de nada, al final lo que depende de todo.

### Paso 1: el modelo (`model/Task`)

Empezá por los datos. `Task` tiene cuatro campos: `id`, `title`, `description` y `completed`. No sabe nada de consola ni de controladores.

- Definí `equals()` y `hashCode()` por `id`: dos tareas son iguales si tienen el mismo id. Lo necesita `tasks.contains(task)` más adelante.

### Paso 2: las excepciones (`excepciones/`)

Antes de escribir lógica, definí cómo va a fallar la app:

- `TaskException`: errores de negocio (la tarea ya existe, no se encontró, la lista está vacía).
- `TaskValidationException`: errores de datos de entrada (id vacío, título vacío, estado nulo).

Tenerlas separadas permite que la vista distinga "el usuario escribió mal" de "la operación no se pudo hacer".

### Paso 3: el repositorio (`model/TaskRepository`)

Guarda y consulta las tareas en una `List<Task>` en memoria. Se arma en este orden:

1. `save`: rechaza duplicados con `TaskException`.
2. `findById`, `findAll`, `findCompletedTasks`, `findPendingTasks`: consultas.
3. `remove(String id)` y `remove(Task task)`: sobrecarga, se puede eliminar por id o por la tarea completa.
4. `findIndexById`, `updateTask`, `updateTaskCompleted`: actualizaciones.

### Paso 4: el controlador (`controller/TaskController`)

Recibe el repositorio por constructor (inyección de dependencias). Cada acción hace lo mismo: **validar → crear el objeto → delegar en el repositorio**.

- `validateTaskData` está sobrecargado: una versión valida los cuatro campos y otra solo `id` y `completed`.
- El controlador nunca lee de la consola: recibe parámetros y lanza excepciones.

### Paso 5: la vista y el `Main` (`view/TaskView`, `Main`)

- `TaskView` muestra el menú (opciones 1 a 8), lee con `Scanner` y llama al controlador. No conoce el repositorio.
- Cada acción atrapa `TaskValidationException | TaskException` y muestra el mensaje; cualquier otra excepción se trata como error inesperado.
- `getTaskInput()` no deja avanzar hasta que los datos no estén vacíos.
- `Main` arma las tres capas de adentro hacia afuera: `TaskRepository` → `TaskController` → `TaskView`, y llama a `showMenu()`.

Hasta acá la app ya funciona, pero las tareas se pierden al cerrarla.

### Paso 6: la persistencia (`persistence/TaskPersistence`)

Con Gson se guarda y carga la lista en `tasks.json`:

- `saveTasks` escribe la lista completa (con `setPrettyPrinting` para que el JSON sea legible).
- `loadTasks` devuelve una lista vacía si el archivo no existe o está vacío. Usa `TypeToken` porque `List<Task>.class` no existe por type erasure.
- `TaskRepository` carga las tareas en el constructor y vuelve a guardar después de cada cambio (`save`, `remove`, `updateTask`, `updateTaskCompleted`).

### Paso 7: refactor con Lombok (`model/Task`)

Con todo funcionando, se reemplazó el código repetitivo de `Task` (~70 líneas) por anotaciones: `@Getter`, `@Setter`, `@AllArgsConstructor`, `@ToString` y `@EqualsAndHashCode(onlyExplicitlyIncluded = true)`. Se hace al final a propósito: primero se entiende el código a mano, después se automatiza.

### Resumen del orden

```
1. Task                      → los datos
2. TaskException / Validation → cómo falla
3. TaskRepository            → dónde viven (memoria)
4. TaskController            → validación + coordinación
5. TaskView + Main           → interacción con el usuario
6. TaskPersistence           → que sobrevivan al cerrar la app
7. Lombok                    → limpiar el modelo
```

## Estado actual

- ✅ Modelo: `Task`, `TaskRepository` (en memoria) y `TaskException`.
- ✅ Controlador: `TaskController` valida los datos (`TaskValidationException`) y delega en el repositorio.
- ✅ Vista: `TaskView` (menú por consola) y `Main`, que arma las tres capas.
- ✅ Persistencia: `TaskPersistence` guarda y carga las tareas en `tasks.json` con Gson.
- ✅ Lombok: `Task` pasó de ~70 líneas a las anotaciones `@Getter`, `@Setter`, `@AllArgsConstructor`, `@ToString` y `@EqualsAndHashCode`.
