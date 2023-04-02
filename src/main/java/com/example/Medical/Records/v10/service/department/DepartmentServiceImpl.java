package com.example.Medical.Records.v10.service.department;

import com.example.Medical.Records.v10.data.entity.Appointment;
import com.example.Medical.Records.v10.data.entity.Department;
import com.example.Medical.Records.v10.data.entity.Diagnosis;
import com.example.Medical.Records.v10.data.repository.AppointmentRepository;
import com.example.Medical.Records.v10.data.repository.DepartmentRepository;
import com.example.Medical.Records.v10.data.repository.DiagnosisRepository;
import com.example.Medical.Records.v10.data.repository.PatientRepository;
import com.example.Medical.Records.v10.dto.diagnoses.CreateDiagnoseDTO;
import com.example.Medical.Records.v10.dto.diagnoses.DiagnoseDTO;
import com.example.Medical.Records.v10.dto.diagnoses.UpdateDiagnoseDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }


    @Override
    public Department findById(Long id) {
        return this.departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid diagnosis ID: " + id));
    }

    @Override
    public Department create(Department department) {
        return this.departmentRepository.saveAndFlush(department);
    }

    @Override
    public Department update(Long id, Department department) {
        Department updated = new Department();
        updated.setId(id);
        return this.departmentRepository.save(updated);
    }

    @Override
    public void delete(Long id) {
        this.departmentRepository.deleteById(id);
    }

    private DiagnoseDTO convertToDiagnoseDTO(Diagnosis diagnosis) {
        return modelMapper.map(diagnosis, DiagnoseDTO.class);
    }
}
