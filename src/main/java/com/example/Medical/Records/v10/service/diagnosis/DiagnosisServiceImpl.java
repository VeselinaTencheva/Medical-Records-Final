package com.example.Medical.Records.v10.service.diagnosis;

import com.example.Medical.Records.v10.entity.Appointment;
import com.example.Medical.Records.v10.entity.Diagnosis;
import com.example.Medical.Records.v10.repository.AppointmentRepository;
import com.example.Medical.Records.v10.repository.DiagnosisRepository;
import com.example.Medical.Records.v10.repository.PatientRepository;
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
public class DiagnosisServiceImpl implements DiagnosisService{

    private final DiagnosisRepository diagnosisRepository;

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<DiagnoseDTO> findAll() {
        List<Diagnosis> diagnoses = diagnosisRepository.findAll();
        List<DiagnoseDTO> diagnoseDTOS = new ArrayList<>();
        diagnoses.forEach(
                diagnosis -> {
                    List<Appointment> appointments = appointmentRepository.findAllByDiagnosis(diagnosis);
                    int patientCount = patientRepository.findDistinctByAppointmentsIn(appointments).size();
                    DiagnoseDTO diagnoseDTO = convertToDiagnoseDTO(diagnosis);
                    diagnoseDTO.setPatientsCount(patientCount);
                    diagnoseDTOS.add(diagnoseDTO);
                }
        );
        return diagnoseDTOS;
    }

    @Override
    public List<DiagnoseDTO> findAllByAppointments(List<Appointment> appointments) {
        ArrayList<DiagnoseDTO> diagnoses = new ArrayList<>();
        appointments.forEach((appointment) ->
                        diagnoses.add(
                            convertToDiagnoseDTO(this.diagnosisRepository.findByAppointments(appointment)))
                );

        return new ArrayList<>(diagnoses);
    }

    @Override
    public DiagnoseDTO findById(Long id) {
        return convertToDiagnoseDTO(this.diagnosisRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid diagnosis ID: " + id)));
    }

    @Override
    public DiagnoseDTO create(CreateDiagnoseDTO diagnosis) {
        return convertToDiagnoseDTO(this.diagnosisRepository.saveAndFlush(modelMapper.map(diagnosis, Diagnosis.class)));
    }

    @Override
    public DiagnoseDTO update(Long id, UpdateDiagnoseDTO updateDiagnoseDTO) {
        Diagnosis diagnosis = modelMapper.map(updateDiagnoseDTO, Diagnosis.class);
        diagnosis.setId(id);
        return convertToDiagnoseDTO(this.diagnosisRepository.save(diagnosis));
    }

    @Override
    public void delete(Long id) {
        this.diagnosisRepository.deleteById(id);
    }

    private DiagnoseDTO convertToDiagnoseDTO(Diagnosis diagnosis) {
        return modelMapper.map(diagnosis, DiagnoseDTO.class);
    }
}
