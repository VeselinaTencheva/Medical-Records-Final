//package com.example.Medical.Records.v10.service.generalPractitioner;
//
//import com.example.Medical.Records.v10.data.entity.physicians.GeneralPractitioner;
//import com.example.Medical.Records.v10.data.repository.GeneralPractitionerRepository;
//import com.example.Medical.Records.v10.dto.physician.CreateGeneralPractitionerDTO;
//import lombok.AllArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class GeneralPractitionerServiceImpl implements GeneralPractitionerService{
//
//    private final GeneralPractitionerRepository generalPractitionerRepository;
//    private final ModelMapper modelMapper;
//
//    @Override
//    public List<GeneralPractitioner> findAll() {
//        return this.generalPractitionerRepository.findAll();
//    }
//
//    @Override
//    public GeneralPractitioner findById(Long id) {
//        return this.generalPractitionerRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid GP ID: " + id));
//    }
//
//    @Override
//    public GeneralPractitioner create(CreateGeneralPractitionerDTO generalPractitioner) {
//        return this.generalPractitionerRepository.saveAndFlush(modelMapper.map(generalPractitioner, GeneralPractitioner.class));
//    }
//
//    @Override
//    public GeneralPractitioner update(Long id, GeneralPractitioner generalPractitioner) {
//
////        Appointment prevAppointment = modelMapper.map(createOrUpdateMedicalExaminationDTO,MedicalExamination.class);
//        generalPractitioner.setId(id);
//        return this.generalPractitionerRepository.save(generalPractitioner);
//    }
//
//    @Override
//    public void delete(Long id) {
//        this.generalPractitionerRepository.deleteById(id);
//    }
//}
