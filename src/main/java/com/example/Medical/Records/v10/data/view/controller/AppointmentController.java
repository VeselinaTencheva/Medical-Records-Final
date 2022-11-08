package com.example.Medical.Records.v10.data.view.controller;

import com.example.Medical.Records.v10.data.entity.*;
import com.example.Medical.Records.v10.data.view.model.appointments.*;
import com.example.Medical.Records.v10.data.view.model.sickLeaves.CreateSickLeaveViewModel;
import com.example.Medical.Records.v10.data.view.model.sickLeaves.UpdateSickLeaveViewModel;
import com.example.Medical.Records.v10.data.view.model.treatments.CreateTreatmentViewModel;
import com.example.Medical.Records.v10.data.view.model.treatments.UpdateTreatmentViewModel;
import com.example.Medical.Records.v10.dto.appointment.AppointmentDTO;
import com.example.Medical.Records.v10.dto.appointment.CreateAppointmentDTO;
import com.example.Medical.Records.v10.dto.appointment.UpdateAppointmentDTO;
import com.example.Medical.Records.v10.dto.sickLeave.CreateSickLeaveDTO;
import com.example.Medical.Records.v10.dto.sickLeave.SickLeaveDTO;
import com.example.Medical.Records.v10.dto.sickLeave.UpdateSickLeaveDTO;
import com.example.Medical.Records.v10.dto.treatment.CreateTreatmentDTO;
import com.example.Medical.Records.v10.dto.treatment.TreatmentDTO;
import com.example.Medical.Records.v10.dto.treatment.UpdateTreatmentDTO;
import com.example.Medical.Records.v10.service.appointment.AppointmentService;
import com.example.Medical.Records.v10.service.diagnosis.DiagnosisService;
import com.example.Medical.Records.v10.service.patient.PatientService;
import com.example.Medical.Records.v10.service.physician.PhysicianService;
import com.example.Medical.Records.v10.service.sickLeave.SickLeaveService;
import com.example.Medical.Records.v10.service.treatment.TreatmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {
    private AppointmentService appointmentService;

    private PhysicianService physicianService;
    private PatientService patientService;

    private DiagnosisService diagnosisService;
    private SickLeaveService sickLeaveService;
    private TreatmentService treatmentService;
    private ModelMapper modelMapper;

    @GetMapping
    public String getAppointments(Model model) {
        final List<AppointmentViewModel> appointments = appointmentService.findAll()
                .stream()
                .map(this::convertToAppointmentViewModel)
                .collect(Collectors.toList());
        model.addAttribute("appointments", appointments);
        return "appointments/all";
    }

    @GetMapping("/create")
    public String createAppointment(Model model) {
        model.addAttribute("physicians", physicianService.findAll());
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("diagnosis", diagnosisService.findAll());
        model.addAttribute("appointment", new CreateAppointmentAndSickLeaveAndTreatmentViewModel());
        return "/appointments/create";
    }

    @PostMapping("/create")
    public String createAppointment(Model model, @Valid @ModelAttribute("appointment") CreateAppointmentAndSickLeaveAndTreatmentViewModel appointment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("physicians", physicianService.findAll());
            model.addAttribute("patients", patientService.findAll());
            model.addAttribute("diagnosis", diagnosisService.findAll());
            return "/appointments/create";
        }

        SickLeaveDTO appointmentSickLeave = null;
        TreatmentDTO appointmentTreatment = null;
        if (appointment.getSickLeaveDuration() > 0) {
            CreateSickLeaveViewModel createSickLeaveViewModel = modelMapper.map(appointment, CreateSickLeaveViewModel.class);
            CreateSickLeaveDTO createSickLeaveDTO = modelMapper.map(createSickLeaveViewModel, CreateSickLeaveDTO.class);
            appointmentSickLeave = sickLeaveService.create(createSickLeaveDTO);
        }

        if (appointment.getTreatmentName() != null && !appointment.getTreatmentName().equals("")) {
            CreateTreatmentViewModel createTreatmentViewModel =
                    new CreateTreatmentViewModel(appointment.getTreatmentName(), appointment.getTreatmentDescription());
            CreateTreatmentDTO createTreatmentDTO = modelMapper.map(createTreatmentViewModel, CreateTreatmentDTO.class);
            appointmentTreatment = treatmentService.create(createTreatmentDTO);
        }

//
        SickLeave sickLeave = appointmentSickLeave != null ? modelMapper.map(appointmentSickLeave, SickLeave.class) : null;
        Treatment treatment = appointmentTreatment != null ? modelMapper.map(appointmentTreatment, Treatment.class) : null;

        CreateAppointmentViewModel createAppointmentViewModel =
                new CreateAppointmentViewModel(
                        appointment.getDate(),
                        appointment.getPatient(),
                        appointment.getPhysician(),
                        sickLeave,
                        appointment.getDiagnosis(),
                        treatment
                );

        CreateAppointmentDTO appointmentDTO = modelMapper.map(createAppointmentViewModel, CreateAppointmentDTO.class);
        appointmentService.create(appointmentDTO);
        return "redirect:/appointments";
    }

    @GetMapping("/update/{id}")
    public String editAppointment(Model model, @PathVariable Long id) {
        model.addAttribute("physicians", physicianService.findAll());
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("diagnosis", diagnosisService.findAll());
        model.addAttribute("treatments", treatmentService.findAll());
        model.addAttribute("appointment",  modelMapper.map(appointmentService.findById(id), UpdateAppointmentAndSickLeaveAndTreatmentViewModel.class));
        return "/appointments/edit";
    }

    @PostMapping("/update/{id}")
    public String editAppointment(Model model, @PathVariable long id,@Valid @ModelAttribute("appointment") UpdateAppointmentAndSickLeaveAndTreatmentViewModel appointment, BindingResult bindingResult) {
         if (bindingResult.hasErrors()) {
             model.addAttribute("physicians", physicianService.findAll());
             model.addAttribute("patients", patientService.findAll());
             model.addAttribute("diagnosis", diagnosisService.findAll());
             model.addAttribute("treatments", treatmentService.findAll());
             return "/appointments/update";
         }

        AppointmentViewModel currentAppointment = this.modelMapper.map(this.appointmentService.findById(appointment.getId()), AppointmentViewModel.class);
        SickLeaveDTO prevAppointmentSickLeave = modelMapper.map(currentAppointment.getSickLeave(), SickLeaveDTO.class);
        TreatmentDTO prevAppointmentTreatment = modelMapper.map(currentAppointment.getTreatment(), TreatmentDTO.class);


//        Set Sick Leave Object
        if (prevAppointmentSickLeave == null && appointment.getSickLeaveDuration() > 0) {
//            create a new sick leave object if there is no sick leave added to the appointment before edit
            CreateSickLeaveViewModel createSickLeaveViewModel = modelMapper.map(appointment, CreateSickLeaveViewModel.class);
            CreateSickLeaveDTO createSickLeaveDTO = modelMapper.map(createSickLeaveViewModel, CreateSickLeaveDTO.class);
            prevAppointmentSickLeave = sickLeaveService.create(createSickLeaveDTO);
        } else if (prevAppointmentSickLeave != null && (appointment.getSickLeaveDuration() > 0)) {
//            if prevAppointmentSickLeave had a value, but it had been deleted on edit
            this.sickLeaveService.delete(prevAppointmentSickLeave.getId());
            prevAppointmentSickLeave = null;
        } else if (prevAppointmentSickLeave != null && !(appointment.getSickLeaveDuration() > 0)) {
            if (!prevAppointmentSickLeave.getStartDate().equals(appointment.getSickLeaveStartDate()) || prevAppointmentSickLeave.getDuration() != appointment.getSickLeaveDuration()) {
                UpdateSickLeaveViewModel updateSickLeaveViewModel = modelMapper.map(appointment, UpdateSickLeaveViewModel.class);
                UpdateSickLeaveDTO updateSickLeaveDTO = modelMapper.map(updateSickLeaveViewModel, UpdateSickLeaveDTO.class);
                prevAppointmentSickLeave = sickLeaveService.update(prevAppointmentSickLeave.getId(),updateSickLeaveDTO);
            }
        }

//        Set Treatment Object
        if (prevAppointmentTreatment == null && appointment.getTreatmentName() != null && !appointment.getTreatmentName().isEmpty()) {
//            create a new Treatment object if there is no Treatment added to the appointment before edit
            CreateTreatmentViewModel createTreatmentViewModel =
                    new CreateTreatmentViewModel(appointment.getTreatmentName(), appointment.getTreatmentDescription());
            CreateTreatmentDTO createTreatmentDTO = modelMapper.map(createTreatmentViewModel, CreateTreatmentDTO.class);
            prevAppointmentTreatment = treatmentService.create(createTreatmentDTO);
        } else if (prevAppointmentTreatment != null && appointment.getTreatmentName().isEmpty()) {
//            if prevAppointmentTreatment had a value, but it had been deleted on edit
            this.treatmentService.delete(prevAppointmentTreatment.getId());
            prevAppointmentTreatment = null;
        } else if (prevAppointmentTreatment != null && !appointment.getTreatmentName().isEmpty()) {
            if (!prevAppointmentTreatment.getName().equals(appointment.getTreatmentName()) || prevAppointmentTreatment.getDescription().equals(appointment.getTreatmentDescription())) {
                UpdateTreatmentViewModel updateTreatmentViewModel =
                        new UpdateTreatmentViewModel(appointment.getTreatmentName(), appointment.getTreatmentDescription());
                UpdateTreatmentDTO updateTreatmentDTO = modelMapper.map(updateTreatmentViewModel, UpdateTreatmentDTO.class);
                prevAppointmentTreatment = treatmentService.update(prevAppointmentTreatment.getId(), updateTreatmentDTO);
            }
        }

        UpdateAppointmentViewModel updateAppointmentViewModel =
                new UpdateAppointmentViewModel(
                        appointment.getDate(),
                        appointment.getPatient(),
                        appointment.getPhysician(),
                        modelMapper.map(prevAppointmentSickLeave, SickLeave.class),
                        appointment.getDiagnosis(),
                        modelMapper.map(prevAppointmentTreatment, Treatment.class)
                );


        appointmentService.update(id, modelMapper.map(updateAppointmentViewModel, UpdateAppointmentDTO.class));
        return "redirect:/appointments";
    }

    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable long id) {
        appointmentService.delete(id);
        return "redirect:/appointments";
    }

    private AppointmentViewModel convertToAppointmentViewModel(AppointmentDTO appointmentDTO) {
        return modelMapper.map(appointmentDTO, AppointmentViewModel.class);
    }
}
