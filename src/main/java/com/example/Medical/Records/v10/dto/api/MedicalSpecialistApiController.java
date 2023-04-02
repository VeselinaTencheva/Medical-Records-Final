//package com.example.Medical.Records.v10.controller.api;
//
////import com.example.Medical.Records.v10.data.entity.physicians.MedicalSpecialist;
//import com.example.Medical.Records.v10.service.medicalSpecialist.MedicalSpecialistService;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@AllArgsConstructor
//public class MedicalSpecialistApiController {
//    private final MedicalSpecialistService medicalSpecialistService;
//
//    @GetMapping(value = "/api/medicalSpecialist")
//    public List<MedicalSpecialist> getMedicalSpecialist() {
//        return medicalSpecialistService.findAll();
//    }
//
//    @GetMapping(value = "/api/medicalSpecialist/{id}")
//    public MedicalSpecialist getMedicalSpecialist(@PathVariable("id") long id) {
//        return medicalSpecialistService.findById(id);
//    }
//
//    @PostMapping(value = "/api/medicalSpecialist")
//    public MedicalSpecialist createMedicalSpecialist(@RequestBody MedicalSpecialist medicalSpecialist) {
//        return medicalSpecialistService.create(medicalSpecialist);
//    }
//
//    @PutMapping(value = "/api/medicalSpecialist/{id}")
//    public MedicalSpecialist updateMedicalSpecialist(@PathVariable("id") long id, @RequestBody MedicalSpecialist medicalSpecialist) {
//        return medicalSpecialistService.update(id, medicalSpecialist);
//    }
//
//    @DeleteMapping(value = "/api/medicalSpecialist/{id}")
//    public void deleteMedicalSpecialist(@PathVariable long id) {
//        medicalSpecialistService.delete(id);
//    }
//}
