
package com.cleverapp.clever.entities.enumeration;


public enum Gender {
    
     FEMENINO("Femenino"), MASCULINO("Masculino");
     
     private String value ;

    private Gender() {
    }

    private Gender(String value) {
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
        return "Gender{" + "value=" + value + '}';
    }
     
     
    
}
