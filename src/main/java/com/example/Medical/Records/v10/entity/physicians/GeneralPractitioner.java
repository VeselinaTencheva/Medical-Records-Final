package com.example.Medical.Records.v10.entity.physicians;

import com.example.Medical.Records.v10.entity.Patient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class GeneralPractitioner extends Physician {

    @Column(name = "practice_code", nullable = false, unique = true)
    @Size(min = 5, max = 5, message="Exact 5")
    private String practiceCode;

    @Column(name = "practice_address", nullable = false)
    private String practiceAddress;

    @OneToMany(mappedBy = "generalPractitioner")
    @JsonIgnoreProperties("generalPractitioner")
    private Set<Patient> patients;

}
