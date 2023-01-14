package com.cleverapp.clever.entities;

import com.cleverapp.clever.entities.enumeration.Gender;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    
    //>>>>>>>>>>>>>>> ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eid;
    @Column(length = 30, nullable = false)
    private String firstName;
    @Column(length = 30, nullable = false)
    private String lastName;    
    @Enumerated(EnumType.STRING)
    private Gender gender ;
    
    //>>>>>>>>>>>>>>> CONSTRUCTORS
    public Employee() {
    }

    public Employee(Integer eid, String firstName, String lastName, Gender gender) {
        this.eid = eid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
    
    //>>>>>>>>>>>>>>> GETTERS AND SETTERS
    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    //>>>>>>>>>>>>>>> TO STRING
    @Override
    public String toString() {
        return "Employee{" + "eid=" + eid + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + '}';
    }

    
    
}
