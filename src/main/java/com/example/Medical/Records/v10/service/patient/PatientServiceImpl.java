package com.example.Medical.Records.v10.service.patient;

import com.example.Medical.Records.v10.entity.Appointment;
import com.example.Medical.Records.v10.entity.Patient;
import com.example.Medical.Records.v10.repository.PatientRepository;
import com.example.Medical.Records.v10.dto.appointment.AppointmentDTO;
import com.example.Medical.Records.v10.dto.diagnoses.DiagnoseDTO;
import com.example.Medical.Records.v10.dto.patient.CreatePatientDTO;
import com.example.Medical.Records.v10.dto.patient.PatientDTO;
import com.example.Medical.Records.v10.dto.patient.UpdatePatientDTO;
import com.example.Medical.Records.v10.service.appointment.AppointmentService;
import com.example.Medical.Records.v10.service.diagnosis.DiagnosisService;
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

    private final DiagnosisService diagnosisService;
    private final AppointmentService appointmentService;
//    private final DiagnosisRepository diagnosisRepository;
//    private final AppointmentRepository appointmentRepository;

    @Override
    public List<PatientDTO> findAll() {
        return patientRepository.findAll().stream()
                .map(this::convertToPatientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DiagnoseDTO> findAllDiagnosesPerPatient(long id) {
        List<AppointmentDTO> appointmentsDTO = appointmentService.findAppointmentsByPatient(modelMapper.map(findById(id), Patient.class));
        List<Appointment> appointments = appointmentsDTO.stream().map((appointmentDTO) -> modelMapper.map(appointmentDTO, Appointment.class)).collect(Collectors.toList());
        List<DiagnoseDTO> diagnoses = diagnosisService.findAllByAppointments(appointments);
        return diagnoses;
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
