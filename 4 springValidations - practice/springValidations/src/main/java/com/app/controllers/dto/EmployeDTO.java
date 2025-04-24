package com.app.controllers.dto;

import com.app.advices.validation.anotation.ValidName;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeDTO {

    /*
     * @NotNull --> Se usa para cuando no se quiere atributos nulos
     * @NotBlank --> No permite cadenas vacías ni que contengan solo espacios (solo para Strings)
     * @NotEmpty --> No permite valores vacíos (colecciones, arreglos, cadenas), pero sí nulos
     * @Pattern --> Valida que una cadena cumpla con una expresión regular (solo para Strings)
     * @Min y @Max --> Restringen valores numéricos a un mínimo y/o máximo
     * @Positive y @PositiveOrZero --> Valida que el número sea mayor que 0 o mayor o igual a 0
     * @Negative y @NegativeOrZero --> Valida que el número sea menor que 0 o menor o igual a 0
     * @Size --> Define el tamaño mínimo y/o máximo para cadenas, colecciones, mapas o arreglos
     * @Digits --> Restringe la cantidad de dígitos enteros y decimales (por ejemplo: @Digits(integer=5, fraction=2))
     * @Past y @Future --> Valida que una fecha esté en el pasado o en el futuro
     * @AssertFalse y @AssertTrue --> Requiere que un valor booleano sea falso o verdadero, respectivamente
     * */

    @NotBlank(message = "El campo name no puedes estar vacio cv")
    @Size(min = 3, max = 25)
    private String name;

    @ValidName
    private String lastname;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "No comple con el formato de email xxxxx@xxxx.xxx")
    private String email;

    @NotNull
    private Long phone;

    @Min(18)
    @Max(65)
    private byte age;

    @Digits(integer = 1, fraction = 2)
    private double height;

    @AssertTrue
    private boolean married;

    @Future
    private LocalDate dateOfBirth;

    @Valid
    private DepartmentDTO department;

}
