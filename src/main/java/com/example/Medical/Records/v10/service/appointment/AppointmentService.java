package com.example.Medical.Records.v10.service.appointment;

import com.example.Medical.Records.v10.data.entity.Appointment;
import com.example.Medical.Records.v10.data.entity.Patient;
import com.example.Medical.Records.v10.dto.appointment.AppointmentDTO;
import com.example.Medical.Records.v10.dto.appointment.CreateAppointmentDTO;
import com.example.Medical.Records.v10.dto.appointment.UpdateAppointmentDTO;

import java.util.List;
public interface AppointmentService {
    List<AppointmentDTO> findAll();

    AppointmentDTO findById(Long id);

    Appointment create(CreateAppointmentDTO appointment);

    Appointment update(Long id, UpdateAppointmentDTO updateAppointmentDTO);

    List<AppointmentDTO> findAppointmentsByPatient(Patient patient);

    void delete(Long id);
}
