package com.example.Medical.Records.v10.service.physician;

import com.example.Medical.Records.v10.data.entity.physicians.Physician;
import com.example.Medical.Records.v10.data.repository.PatientRepository;
import com.example.Medical.Records.v10.data.repository.PhysicianRepository;
import com.example.Medical.Records.v10.dto.physician.CreateGeneralPractitionerDTO;
import com.example.Medical.Records.v10.dto.physician.CreatePhysicianDTO;
import com.example.Medical.Records.v10.dto.physician.PhysicianDTO;
import com.example.Medical.Records.v10.dto.physician.UpdatePhysicianDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PhysicianServiceImpl implements PhysicianService {

    private final ModelMapper modelMapper;
    private final PhysicianRepository physicianRepository;

    private final PatientRepository patientRepository;


    @Override
    public List<PhysicianDTO> findAll() {
        return physicianRepository
                .findAll().stream().map(physician -> {
                    return convertToPhysicianDTO(physician);})
                    .collect(Collectors.toList());
//                .stream()
//                .map(physician -> {
//                    PhysicianDTO physicianDTO = convertToPhysicianDTO(physician);
//                    boolean isGp = true;
//                    int patientsCount = 0;
//                    try {
//                        Physician physician1 = this.generalPractitionerService.findById(physicianDTO.getId());
//                        patientsCount = patientRepository.findDistinctByGeneralPractitioner(generalPractitioner).size();
//                    } catch (IllegalArgumentException e) {
//                        isGp = false;
//                    }
//                    physicianDTO.setGP(isGp);
//                    physicianDTO.setPatientsCount(patientsCount);
//                    return physicianDTO;
//                })
//                .collect(Collectors.toList());
    }

    @Override
    public PhysicianDTO findById(Long id) {
        return convertToPhysicianDTO(this.physicianRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Physician ID: " + id)));
    }

    @Override
    public PhysicianDTO create(CreatePhysicianDTO createPhysicianDTO) {
//        if (!createPhysicianDTO.getPracticeCode().equals("")) {
//            return convertToPhysicianDTO(generalPractitionerService.create(modelMapper.map(createPhysicianDTO, CreateGeneralPractitionerDTO.class)));
//        } else {
            return convertToPhysicianDTO(this.physicianRepository.saveAndFlush(this.modelMapper.map(createPhysicianDTO, Physician.class)));
//        }
    }

    @Override
    public PhysicianDTO update(Long id, UpdatePhysicianDTO physician) {
//        GeneralPractitioner prevGP;
//        try {
//            prevGP = generalPractitionerService.findById(id);
//        } catch (Exception e) {
//            prevGP = null;
//        }

        physician.setId(id);
//        TODO implement update

//        if (prevGP == null && physician.getPracticeCode().isEmpty() && physician.getPracticeCode().isBlank()) {
//            return convertToPhysicianDTO(this.physicianRepository.save(modelMapper.map(physician, Physician.class)));
//        } else if (prevGP == null && (!physician.getPracticeCode().isBlank())) {
//            physicianRepository.delete(modelMapper.map(physician, Physician.class));
//            return convertToPhysicianDTO(
//                    generalPractitionerRepository
//                            .save(modelMapper.map(physician, GeneralPractitioner.class))
//            );
//        } else if (prevGP != null && physician.getPracticeCode().isBlank()) {
//            generalPractitionerRepository.deleteById(id);
//            return convertToPhysicianDTO(physicianRepository.save(modelMapper.map(physician, Physician.class)));
//        } else {
//            return convertToPhysicianDTO(
//                    generalPractitionerRepository.save(modelMapper.map(physician, GeneralPractitioner.class))
//            );
//        }
        return null;
    }

    @Override
    public void delete(Long id) {
        this.physicianRepository.deleteById(id);
    }

    private PhysicianDTO convertToPhysicianDTO(Physician physician) {
        return modelMapper.map(physician, PhysicianDTO.class);
    }
}
