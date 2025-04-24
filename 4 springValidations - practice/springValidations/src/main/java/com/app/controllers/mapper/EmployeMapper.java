package com.app.controllers.mapper;

import com.app.controllers.dto.DepartmentDTO;
import com.app.controllers.dto.EmployeDTO;
import com.app.entities.Department;
import com.app.entities.Employe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeMapper {

    Employe ToEmploye(EmployeDTO employeDTO);
    EmployeDTO ToEmployeDto(Employe employe);
//    Department ToDepartment(DepartmentDTO departmentDTO);
//    DepartmentDTO ToDepartmentDto(Department department);
}
