package com.cleverapp.clever.controllers;

import com.cleverapp.clever.entities.Register;
import com.cleverapp.clever.entities.enumeration.BusinessLocation;
import com.cleverapp.clever.entities.enumeration.RegisterType;
import com.cleverapp.clever.error.ErrorService;
import com.cleverapp.clever.services.RegisterService;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    //>>>>>>>>>>>>>>> REGISTER
    @PostMapping
    public Register register(@RequestParam Integer idEmployee, @RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam RegisterType registerType, @RequestParam BusinessLocation businessLocation) throws ErrorService {
        return registerService.register(idEmployee, date, registerType, businessLocation);
    }

    //>>>>>>>>>>>>>>> LIST REGISTER
    @GetMapping("/list")
    public List<Register> listRegister() {
        return registerService.listRegister();
    }

    //>>>>>>>>>>>>>>> SEARCH REGISTER
    @GetMapping("/search")
    public List<Register> findByDateBetweenWithFilter(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTo, @RequestParam(defaultValue = "") String descriptionFilter, @RequestParam BusinessLocation businessLocation) {
        return registerService.findByDateBetweenWithFilter(dateFrom, dateTo, descriptionFilter, businessLocation);
    }

    //>>>>>>>>>>>>>>> AVERAGE 
    @GetMapping("/average")
    public Map<String, Double> averageByLocation(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTo, @RequestParam BusinessLocation businessLocation) {
        return registerService.averageByLocation(dateFrom, dateTo, businessLocation);
    }

}
