package com.empresa.project.genericos.leccion08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

// T = tipo del item que se guarda, K = tipo de la clave para buscarlo
public class DataStore<T, K> {
    // La lista guarda los items en orden; el mapa permite buscarlos rápido por clave
    private final List<T> dataList;
    private final Map<K, T> dataMap;

    public DataStore() {
        this.dataList = new ArrayList<>();
        this.dataMap = new HashMap<>();
    }

    // Devuelve false si la clave ya existe, true si se agregó
    public boolean add(K key, T item) {
        Objects.requireNonNull(key, "La clave no puede ser nula");
        Objects.requireNonNull(item, "El item no puede ser nulo");

        if (dataMap.containsKey(key)) {
            return false;
        }
        dataList.add(item);
        dataMap.put(key, item);
        return true;
    }

    // Elimina el item de las dos estructuras y lo devuelve (null si no existía)
    public T remove(K key) {
        Objects.requireNonNull(key, "La clave no puede ser nula");
        T item = dataMap.remove(key);
        if (item != null) {
            dataList.remove(item);
        }
        return item;
    }

    // Devuelve el item o null si no existe esa clave
    public T find(K key) {
        Objects.requireNonNull(key, "La clave no puede ser nula");
        return dataMap.get(key);
    }

    // Devuelve una vista de solo lectura: quien la reciba no puede modificar
    // la lista interna del DataStore
    public List<T> getAll() {
        return Collections.unmodifiableList(dataList);
    }
}
