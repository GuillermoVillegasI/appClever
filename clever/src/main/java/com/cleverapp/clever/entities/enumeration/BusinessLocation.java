package com.cleverapp.clever.entities.enumeration;

public enum BusinessLocation {

    ARGENTINA("Argentina"), BRASIL("Brasil"), ESPAÑA("España");

    private String value;

    private BusinessLocation() {
    }

    private BusinessLocation(String value) {
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
        return "Location{" + "value=" + value + '}';
    }
    
    

}
