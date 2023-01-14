package com.cleverapp.clever.controllers;

import com.cleverapp.clever.entities.Employee;
import com.cleverapp.clever.entities.enumeration.Gender;
import com.cleverapp.clever.error.ErrorService;
import com.cleverapp.clever.services.EmployeeService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //>>>>>>>>>>>>>>> REGISTER 
    @PostMapping
    public Employee registerEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Gender gender) throws ErrorService {
        return employeeService.register(firstName.toUpperCase(), lastName.toUpperCase(), gender);
    }

    //>>>>>>>>>>>>>>> LIST EMPLOYEE
    @GetMapping("/list")
    public ArrayList<Employee> listEmployee() {
        return employeeService.listEmployees();
    }
}
