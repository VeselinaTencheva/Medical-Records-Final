package com.example.Medical.Records.v10.service.department;

import com.example.Medical.Records.v10.data.entity.Appointment;
import com.example.Medical.Records.v10.data.entity.Department;
import com.example.Medical.Records.v10.dto.diagnoses.CreateDiagnoseDTO;
import com.example.Medical.Records.v10.dto.diagnoses.DiagnoseDTO;
import com.example.Medical.Records.v10.dto.diagnoses.UpdateDiagnoseDTO;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    Department findById(Long id);

    Department create(Department department);

    Department update(Long id, Department department);

    void delete(Long id);
}
