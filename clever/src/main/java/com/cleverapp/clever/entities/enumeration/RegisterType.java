
package com.cleverapp.clever.entities.enumeration;


public enum RegisterType {
    ENTRADA("Entrada"), SALIDA("Salida");
    
    private String value;

    private RegisterType() {
    }

    private RegisterType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "RegisterType{" + "value=" + value + '}';
    }
    
    
}
