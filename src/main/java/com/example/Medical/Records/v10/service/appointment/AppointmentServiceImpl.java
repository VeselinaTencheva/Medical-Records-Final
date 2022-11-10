package com.example.Medical.Records.v10.service.appointment;

import com.example.Medical.Records.v10.data.entity.Appointment;
import com.example.Medical.Records.v10.data.entity.Patient;
import com.example.Medical.Records.v10.data.repository.AppointmentRepository;
import com.example.Medical.Records.v10.dto.appointment.AppointmentDTO;
import com.example.Medical.Records.v10.dto.appointment.CreateAppointmentDTO;
import com.example.Medical.Records.v10.dto.appointment.UpdateAppointmentDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService{
    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<AppointmentDTO> findAll() {
        return appointmentRepository.findAll().stream()
                .map(this::convertToAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO findById(Long id) {
        return modelMapper
                .map(
                        this.appointmentRepository
                                .findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("Invalid appointment ID: " + id)),
                        AppointmentDTO.class
                );
    }

    @Override
    public Appointment create(CreateAppointmentDTO createAppointmentDTO) {
//        Appointment appointment = modelMapper.map(createAppointmentDTO, Appointment.class);
//        if (appointment.getSickLeave().getDuration() <= 0 && appointment.getSickLeave().getStartDate() == null) {
//            appointment.setSickLeave(null);
//        }
//        if (appointment.getTreatment().getName() == null) {
//            appointment.setTreatment(null);
//        }
        return this.appointmentRepository.save(modelMapper.map(createAppointmentDTO, Appointment.class));
    }

    @Override
    public Appointment update(Long id, UpdateAppointmentDTO appointmentDTO) {

        Appointment appointment = modelMapper.map(appointmentDTO,Appointment.class);
        appointment.setId(id);
        return this.appointmentRepository.saveAndFlush(appointment);
    }

    @Override
    public List<AppointmentDTO> findAppointmentsByPatient(Patient patient) {
        return appointmentRepository.findAllByPatient(patient).stream()
                .map(this::convertToAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        this.appointmentRepository.deleteById(id);
    }

    private AppointmentDTO convertToAppointmentDTO(Appointment appointment) {
        return modelMapper.map(appointment, AppointmentDTO.class);
    }
}
