package com.cleverapp.clever.entities.enumeration;

//>>>>>>>>>>>>>>> ENUM BUSINESS LOCATION
public enum BusinessLocation {

    ARGENTINA("Argentina"), BRASIL("Brasil"), ESPAÑA("España");
    private String value;
    
    //>>>>>>>>>>>>>>> CONSTRUCTORS
    private BusinessLocation() {
    }

    private BusinessLocation(String value) {
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
        return "Location{" + "value=" + value + '}';
    }
}
