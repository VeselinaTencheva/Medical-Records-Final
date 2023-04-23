package com.example.Medical.Records.v10.service.sickLeave;

import com.example.Medical.Records.v10.entity.Appointment;
import com.example.Medical.Records.v10.entity.SickLeave;
import com.example.Medical.Records.v10.repository.SickLeaveRepository;
import com.example.Medical.Records.v10.dto.sickLeave.CreateSickLeaveDTO;
import com.example.Medical.Records.v10.dto.sickLeave.SickLeaveDTO;
import com.example.Medical.Records.v10.dto.sickLeave.UpdateSickLeaveDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SickLeaveServiceImpl implements SickLeaveService {

    private final SickLeaveRepository sickLeaveRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<SickLeaveDTO> findAll() {
        return sickLeaveRepository.findAll().stream()
                .map(sickLeave -> {
                    Appointment appointment = sickLeave.getAppointment();
                    final SickLeaveDTO sickLeaveDTO = convertToSickLeaveDTO(sickLeave);
                    sickLeaveDTO.setAppointment(appointment);
                    sickLeaveDTO.setPatient(appointment.getPatient());
                    sickLeaveDTO.setPhysician(appointment.getPhysician());
                    return sickLeaveDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public SickLeaveDTO findById(Long id) {
        return modelMapper
                .map(
                        this.sickLeaveRepository
                                .findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("Invalid ick Leave ID: " + id)),
                        SickLeaveDTO.class
                );
    }

    @Override
    public SickLeaveDTO create(CreateSickLeaveDTO sickLeave) {
        return convertToSickLeaveDTO(this.sickLeaveRepository.save(this.modelMapper.map(sickLeave, SickLeave.class)));
    }

    @Override
    public SickLeaveDTO update(Long id, UpdateSickLeaveDTO updateSickLeaveDTO) {
        SickLeave sickLeave = modelMapper.map(updateSickLeaveDTO, SickLeave.class);
        sickLeave.setId(id);
        return convertToSickLeaveDTO(this.sickLeaveRepository.save(sickLeave));
    }

    @Override
    public void delete(Long id) {
        this.sickLeaveRepository.deleteById(id);
    }

    private SickLeaveDTO convertToSickLeaveDTO(SickLeave sickLeave) {
        return modelMapper.map(sickLeave, SickLeaveDTO.class);
    }
}
