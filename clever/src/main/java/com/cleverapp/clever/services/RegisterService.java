package com.cleverapp.clever.services;

import com.cleverapp.clever.entities.Employee;
import com.cleverapp.clever.entities.Register;
import com.cleverapp.clever.entities.enumeration.BusinessLocation;
import com.cleverapp.clever.entities.enumeration.Gender;
import com.cleverapp.clever.entities.enumeration.RegisterType;
import com.cleverapp.clever.error.ErrorService;
import com.cleverapp.clever.repositories.RegisterRepository;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private EmployeeService employeeService;

    //>>>>>>>>>>>>>>> SERVICE 1 - REGISTER
    @Transactional(rollbackFor = {Exception.class})
    public Register register(Integer idEmployee, LocalDate date, RegisterType registerType, BusinessLocation businessLocation) throws ErrorService {
        validate(idEmployee, date, registerType, businessLocation);
        Register register = new Register();
        Employee employee = employeeService.searchById(idEmployee);
        register.setEmployee(employee);
        register.setDate(date);
        register.setRegisterType(registerType);
        register.setBusinessLocation(businessLocation);
        return registerRepository.save(register);
    }

    //>>>>>>>>>>>>>>> SERVICE 2 - SEARCH REGISTER
    @Transactional(readOnly = true)
    public List<Register> findByDateBetweenWithFilter(LocalDate dateFrom, LocalDate dateTo, String descriptionFilter, BusinessLocation businessLocation) {
        return registerRepository.findByDateBetweenWithFilter(dateFrom, dateTo, "%" + descriptionFilter + "%", businessLocation);
    }

    //>>>>>>>>>>>>>>> SERVICE 3 - AVERAGE
    @Transactional(readOnly = true)
    public Map<String, Double> averageByLocation(LocalDate dateFrom, LocalDate dateTo, BusinessLocation businessLocation) {
        List<Register> registers = registerRepository.findByDateBetween(dateFrom, dateTo, businessLocation);
        int male = 0;
        for (Register register : registers) {
            if (register.getEmployee().getGender().equals(Gender.MASCULINO)) {
                male++;
            }
        }
        double malePercentage = (male * 100) / registers.size();
        double femalePercentage = 100 - malePercentage;
        Map<String, Double> map = new HashMap();
        map.put("Male_average", malePercentage);
        map.put("Female_average", femalePercentage);
        return map;
    }

    //>>>>>>>>>>>>>>> LIST REGISTER
    public List<Register> listRegister() {
        return registerRepository.findAll();
    }

    //>>>>>>>>>>>>>>> FIND REGISTER BY ID
    @Transactional(readOnly = true)
    public Register findById(Integer id) throws ErrorService {
        Optional<Register> answer = registerRepository.findById(id);
        if (!answer.isPresent()) {
            throw new ErrorService("The register does not exist.");
        }
        return answer.get();
    }

    //>>>>>>>>>>>>>>> PARAMETERS VALIDATION
    private void validate(Integer idEmployee, LocalDate date, RegisterType registerType, BusinessLocation businessLocation) throws ErrorService {

        if (idEmployee == null) {
            throw new ErrorService("The employee does not exist.");
        }
        if (registerType == null || registerType.getValue().isEmpty()) {
            throw new ErrorService("The register type cannot be null.");
        }
        if (businessLocation == null || businessLocation.getValue().isEmpty()) {
            throw new ErrorService("The business Location cannot be null.");
        }
    }
}
