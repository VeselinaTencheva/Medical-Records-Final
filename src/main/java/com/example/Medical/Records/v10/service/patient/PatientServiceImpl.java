package com.example.Medical.Records.v10.service.patient;

import com.example.Medical.Records.v10.data.entity.Patient;
import com.example.Medical.Records.v10.data.repository.PatientRepository;
import com.example.Medical.Records.v10.dto.patient.CreatePatientDTO;
import com.example.Medical.Records.v10.dto.patient.PatientDTO;
import com.example.Medical.Records.v10.dto.patient.UpdatePatientDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PatientDTO> findAll() {
        return patientRepository.findAll().stream()
                .map(this::convertToPatientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO findById(Long id) {
        return convertToPatientDTO(this.patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Patient ID: " + id)));
    }

    @Override
    public PatientDTO create(CreatePatientDTO patient) {
        return convertToPatientDTO(this.patientRepository.save(modelMapper.map(patient, Patient.class)));
    }

    @Override
    public PatientDTO update(Long id, UpdatePatientDTO updatePatientDTO) {
        Patient patient = modelMapper.map(updatePatientDTO, Patient.class);
        patient.setId(id);
        return convertToPatientDTO(this.patientRepository.save(patient));
    }

    @Override
    public void delete(Long id) {
        this.patientRepository.deleteById(id);
    }

    private PatientDTO convertToPatientDTO(Patient patient) {
        return modelMapper.map(patient, PatientDTO.class);
    }

}
