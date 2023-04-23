package com.example.Medical.Records.v10.service.treatment;

import com.example.Medical.Records.v10.entity.Treatment;
import com.example.Medical.Records.v10.repository.TreatmentRepository;
import com.example.Medical.Records.v10.dto.treatment.CreateTreatmentDTO;
import com.example.Medical.Records.v10.dto.treatment.TreatmentDTO;
import com.example.Medical.Records.v10.dto.treatment.UpdateTreatmentDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TreatmentServiceImpl implements TreatmentService {

    private final TreatmentRepository treatmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TreatmentDTO> findAll() {
        return this.treatmentRepository.findAll().stream()
                .map(this::convertToTreatmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TreatmentDTO findById(Long id) {
        return modelMapper.map(this.treatmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Treatment ID: " + id)), TreatmentDTO.class);
    }

    @Override
    public TreatmentDTO create(CreateTreatmentDTO treatment) {
        return convertToTreatmentDTO(this.treatmentRepository.saveAndFlush(this.modelMapper.map(treatment, Treatment.class)));
    }

    @Override
    public TreatmentDTO update(Long id, UpdateTreatmentDTO updateTreatmentDTO) {
        Treatment treatment = modelMapper.map(updateTreatmentDTO, Treatment.class);
        treatment.setId(id);
        return convertToTreatmentDTO(this.treatmentRepository.save(treatment));
    }

    @Override
    public void delete(Long id) {
        this.treatmentRepository.deleteById(id);
    }

    private TreatmentDTO convertToTreatmentDTO(Treatment treatment) {
        return modelMapper.map(treatment, TreatmentDTO.class);
    }
}
