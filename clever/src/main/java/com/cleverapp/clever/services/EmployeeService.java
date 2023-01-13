package com.cleverapp.clever.services;

import com.cleverapp.clever.entities.Employee;
import com.cleverapp.clever.entities.enumeration.Gender;
import com.cleverapp.clever.error.ErrorService;
import com.cleverapp.clever.repositories.EmployeeRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

//    ------------CREATE EMPLOYEE
    @Transactional(rollbackFor = {Exception.class})
    public Employee register(String firstName, String lastName, Gender gender) throws ErrorService {

        validate(firstName, lastName);
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setGender(gender);

        return employeeRepository.save(employee);

    }

    //------------LIST EMPLOYEES
    public ArrayList<Employee> listEmployees() {
        return (ArrayList<Employee>) employeeRepository.findAll();
    }

    //------------SEARCH EMPLOYEE BY ID
    @Transactional(readOnly = true)
    public Employee searchById(Integer id) throws ErrorService {
        Optional<Employee> answer = employeeRepository.findById(id);
        if (answer.isPresent()) {
            return answer.get();
        } else {
            throw new ErrorService("The employee does not exist.");
        }
    }

    //------------PARAMETERS VALIDATION
    private void validate(String firstName, String lastName) throws ErrorService {
        if (firstName == null || firstName.isEmpty()) {
            throw new ErrorService("The name cannot be null.");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new ErrorService("Last name cannot be null.");
        }
    }

}
