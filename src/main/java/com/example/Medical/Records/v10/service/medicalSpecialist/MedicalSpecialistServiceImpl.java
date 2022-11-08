//package com.example.Medical.Records.v10.service.medicalSpecialist;
//
//import com.example.Medical.Records.v10.data.entity.physicians.MedicalSpecialist;
//import com.example.Medical.Records.v10.data.repository.MedicalSpecialistRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class MedicalSpecialistServiceImpl implements MedicalSpecialistService{
//
//    private final MedicalSpecialistRepository medicalSpecialistRepository;
//
//    @Override
//    public List<MedicalSpecialist> findAll() {
//        return this.medicalSpecialistRepository.findAll();
//    }
//
//    @Override
//    public MedicalSpecialist findById(Long id) {
//        return this.medicalSpecialistRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid Medical Specialist ID: " + id));
//    }
//
//    @Override
//    public MedicalSpecialist create(MedicalSpecialist medicalSpecialist) {
//        return this.medicalSpecialistRepository.saveAndFlush(medicalSpecialist);
//    }
//
//    @Override
//    public MedicalSpecialist update(Long id, MedicalSpecialist medicalSpecialist) {
//        medicalSpecialist.setId(id);
//        return this.medicalSpecialistRepository.save(medicalSpecialist);
//    }
//
//    @Override
//    public void delete(Long id) {
//        this.medicalSpecialistRepository.deleteById(id);
//    }
//}
