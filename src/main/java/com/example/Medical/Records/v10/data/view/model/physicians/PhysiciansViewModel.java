package com.example.Medical.Records.v10.data.view.model.physicians;

import com.example.Medical.Records.v10.data.entity.DepartmentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhysiciansViewModel {
    private long id;
    private String name;
    private String medicalUUID;
    private DepartmentType departmentType;
    private boolean isGP;
    private int patientsCount;
}
