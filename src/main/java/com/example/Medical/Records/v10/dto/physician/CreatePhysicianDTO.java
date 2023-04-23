package com.example.Medical.Records.v10.dto.physician;

import com.example.Medical.Records.v10.entity.DepartmentType;
import com.example.Medical.Records.v10.dto.user.CreateUserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePhysicianDTO extends CreateUserDTO {
//    private long id;
//    private String name;
    private String medicalUUID;
    private Set<DepartmentType> departmentType;
    private String practiceCode;
    private String practiceAddress;
}
