package com.app.services;

import com.app.controllers.dto.EmployeDTO;
import com.app.entities.Department;
import com.app.entities.Employe;
import com.app.persistence.IEmployeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeService {

    private IEmployeRepository iEmployeRepository;

    public EmployeService(IEmployeRepository iEmployeRepository) {
        this.iEmployeRepository = iEmployeRepository;
    }

    public Employe saveEmploye(EmployeDTO employeDTO) {
        Employe employe = Employe.builder()
                .name(employeDTO.getName())
                .lastname(employeDTO.getLastname())
                .email(employeDTO.getEmail())
                .phone(employeDTO.getPhone())
                .age(employeDTO.getAge())
                .height(employeDTO.getHeight())
                .married(employeDTO.isMarried())
                .dateOfBirth(employeDTO.getDateOfBirth())
                .department(Department.builder()
                        .name(employeDTO.getDepartment().getName())
                        .city(employeDTO.getDepartment().getCity())
                        .build())
                .build();
        return this.iEmployeRepository.save(employe);
    }
}
