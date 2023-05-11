package com.example.Medical.Records.v10.data.entity.physicians;//package com.example.Medical.Records.entity;

import com.example.Medical.Records.v10.entity.Department;
import com.example.Medical.Records.v10.entity.physicians.Physician;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class MedicalSpecialist extends Physician {

    @Column(name = "certificate_id", nullable = false, unique = true)
    private String certificateId;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Department> departments;
}
