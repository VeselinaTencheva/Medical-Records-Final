package com.example.Medical.Records.v10.service.diagnosis;

import com.example.Medical.Records.v10.data.entity.Appointment;
import com.example.Medical.Records.v10.data.entity.Diagnosis;
import com.example.Medical.Records.v10.data.repository.DiagnosisRepository;
import com.example.Medical.Records.v10.dto.diagnoses.CreateDiagnoseDTO;
import com.example.Medical.Records.v10.dto.diagnoses.DiagnoseDTO;
import com.example.Medical.Records.v10.dto.diagnoses.UpdateDiagnoseDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DiagnosisServiceImpl implements DiagnosisService{

    private final DiagnosisRepository diagnosisRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<DiagnoseDTO> findAll() {
        return diagnosisRepository.findAll().stream()
                .map(this::convertToDiagnoseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DiagnoseDTO> findAllByAppointments(List<Appointment> appointments) {
        ArrayList<DiagnoseDTO> diagnoses = new ArrayList<>();
        appointments
                .stream()
                .map((appointment) ->
                        diagnoses.add(
                            convertToDiagnoseDTO(this.diagnosisRepository.findByAppointments(appointment)))
                );

        return diagnoses.stream().collect(Collectors.toList());
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
