package com.example.Medical.Records.v10.data.view.model.patients;

import com.example.Medical.Records.v10.data.entity.physicians.GeneralPractitioner;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class CreatePatientViewModel {
    @NotBlank(message = "Name is mandatory")
    @Size(min = 5, max=30, message = "Name must be between 5 and 30 characters")
    private String name;

    @NotBlank(message = "SSN is mandatory")
    @Digits(integer = 10, fraction = 0,  message = "SSN must contains only digits")
    @Size(min = 10, max = 10, message = "SSN must be exact 10 integers")
    private String ssn;

    private boolean hasInsurance;

    @NotNull(message = "General Practitioner is mandatory")
    private GeneralPractitioner generalPractitioner;
}
