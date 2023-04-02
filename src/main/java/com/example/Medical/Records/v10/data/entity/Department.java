package com.example.Medical.Records.v10.data.entity;

import com.example.Medical.Records.v10.data.entity.physicians.Physician;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Department extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated
    private DepartmentType departmentType;

    @ManyToMany(mappedBy = "departments", fetch = FetchType.EAGER)
    private Set<Physician> physicians;
}
