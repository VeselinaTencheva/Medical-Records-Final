//package com.example.Medical.Records.v10.controller.api;
//
//import com.example.Medical.Records.v10.data.entity.Patient;
//import com.example.Medical.Records.v10.service.patient.PatientService;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Set;
//
//@RestController
//@AllArgsConstructor
//public class PatientApiController {
//    private final PatientService patientService;
//
//    @GetMapping(value = "/api/patients")
//    public List<Patient> getPatients() {
//        return patientService.findAll();
//    }
//
//    @GetMapping(value = "/api/patients/{id}")
//    public Patient getPatient(@PathVariable("id") long id) {
//        return patientService.findById(id);
//    }
//
//    @PostMapping(value = "/api/patients")
//    public Patient createPatient(@RequestBody Patient patient) {
//        return patientService.create(patient);
//    }
//
//    @PutMapping(value = "/api/patients/{id}")
//    public Patient updatePatient(@PathVariable("id") long id, @RequestBody Patient patient) {
//        return patientService.update(id, patient);
//    }
//
//    @DeleteMapping(value = "/api/patients/{id}")
//    public void deletePatient(@PathVariable long id) {
//        patientService.delete(id);
//    }
//}
