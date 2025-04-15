package com.app.controllers;


import com.app.controllers.dto.EmployeDTO;
import com.app.entities.Employe;
import com.app.services.EmployeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeController {

    private EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @PostMapping("/save")
    public ResponseEntity<Employe> saveEmploye(@RequestBody @Valid EmployeDTO employeDTO) {
        return new ResponseEntity<>(this.employeService.saveEmploye(employeDTO), HttpStatus.CREATED);
    }
}
