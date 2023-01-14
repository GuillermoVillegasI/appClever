package com.cleverapp.clever.entities;

import com.cleverapp.clever.entities.enumeration.BusinessLocation;
import com.cleverapp.clever.entities.enumeration.RegisterType;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Register {

    //>>>>>>>>>>>>>>> ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rid;
    @ManyToOne(optional = false)
    @JoinColumn(name = "eid")
    private Employee employee;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private RegisterType registerType;
    @Enumerated(EnumType.STRING)
    private BusinessLocation businessLocation;

    //>>>>>>>>>>>>>>> CONSTRUCTORS
    public Register() {
    }

    public Register(Integer rid, Employee employee, LocalDate date, RegisterType registerType, BusinessLocation businessLocation) {
        this.rid = rid;
        this.employee = employee;
        this.date = date;
        this.registerType = registerType;
        this.businessLocation = businessLocation;
    }

    //>>>>>>>>>>>>>>> GETTERS AND SETTERS
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public RegisterType getRegisterType() {
        return registerType;
    }

    public void setRegisterType(RegisterType registerType) {
        this.registerType = registerType;
    }

    public BusinessLocation getBusinessLocation() {
        return businessLocation;
    }

    public void setBusinessLocation(BusinessLocation businessLocation) {
        this.businessLocation = businessLocation;
    }

    //>>>>>>>>>>>>>>> TO STRING
    @Override
    public String toString() {
        return "Register{" + "rid=" + rid + ", employee=" + employee + ", date=" + date + ", registerType=" + registerType + ", businessLocation=" + businessLocation + '}';
    }

}
