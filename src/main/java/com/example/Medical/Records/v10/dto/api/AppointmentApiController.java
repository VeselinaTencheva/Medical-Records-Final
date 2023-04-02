package com.example.Medical.Records.v10.dto.api;

import com.example.Medical.Records.v10.data.entity.Appointment;
import com.example.Medical.Records.v10.dto.appointment.AppointmentDTO;
import com.example.Medical.Records.v10.dto.appointment.CreateAppointmentDTO;
import com.example.Medical.Records.v10.dto.appointment.UpdateAppointmentDTO;
import com.example.Medical.Records.v10.service.appointment.AppointmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
public class AppointmentApiController {
    private final AppointmentService appointmentService;
    private final ModelMapper modelMapper;

    @GetMapping(value = "/api/appointments")
    public List<AppointmentDTO> getAppointments() {
        return appointmentService.findAll();
    }

    @GetMapping(value = "/api/appointments/{id}")
    public AppointmentDTO getAppointment(@PathVariable("id") long id) {
        return appointmentService.findById(id);
    }

    @PostMapping(value = "/api/appointments")
    public Appointment createAppointment(@RequestBody CreateAppointmentDTO appointment) {
        return appointmentService.create(appointment);
    }

    @PutMapping(value = "/api/appointments/{id}")
    public Appointment updateAppointment(@PathVariable("id") long id, @RequestBody UpdateAppointmentDTO appointment) {
        return appointmentService.update(id, appointment);
    }

    @DeleteMapping(value = "/api/appointments/{id}")
    public void deleteAppointment(@PathVariable long id) {
        appointmentService.delete(id);
    }
}
