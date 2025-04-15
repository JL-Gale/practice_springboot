package com.app.controllers.dto;

import com.app.entities.Department;
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
    * @NotNull ->
    * @NotBlank ->
    * @NotEmpty ->
    * @Min y @Max ->
    * @Size ->
    * @@Digits ->
    * @Past y @Future ->
    * @AssertFalse y @AssertTrue ->
     * */

    @NotBlank(message = "El campo name no puedes estar vacio cv")
    @Size(min = 3, max = 25)
    private String name;

    @NotBlank
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
    private Department department;

}
