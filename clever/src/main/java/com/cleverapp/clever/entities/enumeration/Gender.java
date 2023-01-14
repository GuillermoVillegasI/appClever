
package com.cleverapp.clever.entities.enumeration;

//>>>>>>>>>>>>>>> ENUM GENDER
public enum Gender {    
    
     FEMENINO("Femenino"), MASCULINO("Masculino");     
     private String value ;
     
    //>>>>>>>>>>>>>>> CONSTRUCTORS 
    private Gender() {
    }

    private Gender(String value) {
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
        return "Gender{" + "value=" + value + '}';
    }
}
