
package com.cleverapp.clever.entities.enumeration;

//>>>>>>>>>>>>>>> ENUM REGISTER TYPE
public enum RegisterType {
    
    ENTRADA("Entrada"), SALIDA("Salida");
    private String value;

    //>>>>>>>>>>>>>>> CONSTRUCTORS
    private RegisterType() {
    }
    
    private RegisterType(String value) {
        this.value = value;
    }

    //>>>>>>>>>>>>>>> GETTERS AND SETTERS
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //>>>>>>>>>>>>>>> TO STRING
    @Override
    public String toString() {
        return "RegisterType{" + "value=" + value + '}';
    }  
}
