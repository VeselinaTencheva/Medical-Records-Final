package com.example.Medical.Records.v10.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "diagnosis")
public class Diagnosis extends BaseEntity {

    @NotBlank(message = "Name is mandatory")
    @Size(min = 5, max=30, message = "Name must be between 5 and 30 characters")
    private String name;

    @Size(min = 5, max=50, message = "Description must be between 5 and 50 characters")
    private String description;

    @OneToMany(mappedBy = "diagnosis")
    @JsonIgnoreProperties("diagnosis")
    private Set<Appointment> appointments;

}
