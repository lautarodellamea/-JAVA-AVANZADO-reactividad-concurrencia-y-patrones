package com.empresa.project.genericos.leccion01;

// Sin genéricos: la caja guarda un Object, así que acepta cualquier cosa.
public class BoxObject {
    private Object value;

    public BoxObject(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
