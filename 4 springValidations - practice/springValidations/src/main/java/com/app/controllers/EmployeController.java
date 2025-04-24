package com.app.controllers;


import com.app.controllers.dto.EmployeDTO;
import com.app.controllers.mapper.EmployeMapper;
import com.app.entities.Employe;
import com.app.services.EmployeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeController {

    private EmployeService employeService;
    private EmployeMapper employeMapper;

    public EmployeController(EmployeService employeService, EmployeMapper employeMapper) {
        this.employeService = employeService;
        this.employeMapper = employeMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeDTO> saveEmploye(@RequestBody @Valid EmployeDTO employeDTO) {

        return ResponseEntity.status(HttpStatus.CREATED).body(employeMapper.ToEmployeDto(employeService.saveEmploye(employeDTO)));
//        return new ResponseEntity<>(this.employeService.saveEmploye(employeDTO), HttpStatus.CREATED);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employe>> findall() {
        return ResponseEntity.status(HttpStatus.OK).body(employeService.findAllEnploye());
    }
}
