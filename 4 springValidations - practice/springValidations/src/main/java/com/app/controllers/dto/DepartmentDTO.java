package com.app.controllers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 3, max = 25)
    private String city;
}
