package com.example.Medical.Records.v10.dto.physician;

import com.example.Medical.Records.v10.entity.DepartmentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhysicianDTO {
    private long id;
    private String name;
    private String medicalUUID;
    private DepartmentType departmentType;
    private boolean isGP;
    private int patientsCount;
}
