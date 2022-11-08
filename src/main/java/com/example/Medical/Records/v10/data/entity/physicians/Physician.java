package com.example.Medical.Records.v10.data.entity.physicians;

import com.example.Medical.Records.v10.data.entity.DepartmentType;
import com.example.Medical.Records.v10.data.entity.User;
import com.example.Medical.Records.v10.data.entity.Appointment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Physician extends User {
//TODO think about this to become an abstract class
    @Column(name = "medical_uuid", nullable = false, unique = true)
    @NotNull(message = "Medical UUID is mandatory")
    @Size(min = 6, max = 6, message="\"Medical UUID must be exact 6")
    private String medicalUUID;

    @Enumerated
    private DepartmentType departmentType;

    @OneToMany(mappedBy = "physician")
    @JsonIgnoreProperties("physician")
    private Set<Appointment> appointments;


//    @OneToMany(fetch = FetchType.EAGER)
//    private Set<Appointment> appointments;

}