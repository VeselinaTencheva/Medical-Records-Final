package com.example.Medical.Records.v10.data.entity;

import com.example.Medical.Records.v10.data.entity.physicians.GeneralPractitioner;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient extends User {

    @Column(name = "ssn", nullable = false, unique = true)
    @NotNull(message = "SSN is mandatory")
    @Digits(integer = 10, fraction = 0,  message = "SSN must contains only digits")
    @Size(min = 10, max = 10, message = "SSN must be exact 10 integers")
    private String ssn;

    @Column(name = "has_insurance", nullable = false)
    private boolean hasInsurance;

    @ManyToOne
    @JoinColumn(name = "generalPractitioner_id")
    @NotNull(message = "General Practitioner is mandatory")
    private GeneralPractitioner generalPractitioner;

    @OneToMany(mappedBy = "patient")
    @JsonIgnoreProperties("patient")
    private Set<Appointment> appointments;

}