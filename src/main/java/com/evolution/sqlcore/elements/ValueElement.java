package com.evolution.sqlcore.elements;

public class ValueElement {
    private Object value;
    private String alias;
    public Object getValue() {
        return value;
    }
    public String getAlias() {
        return alias;
    }
    public ValueElement setValue(Object value) {
        this.value = value;
        return this;
    }
    public ValueElement setAlias(String alias) {
        this.alias = alias;
        return this;
    }
}

