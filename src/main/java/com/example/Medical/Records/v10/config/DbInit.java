package com.example.Medical.Records.v10.config;

import com.example.Medical.Records.v10.data.repository.GeneralPractitionerRepository;
import com.example.Medical.Records.v10.data.repository.PatientRepository;
import com.example.Medical.Records.v10.data.repository.PhysicianRepository;
import com.example.Medical.Records.v10.data.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DbInit implements CommandLineRunner {

    private UserRepository userRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private GeneralPractitionerRepository generalPractitionerRepository;

    @Autowired
    private PhysicianRepository physicianRepository;

//    @Autowired
//    private PasswordEncoder encoder;

    public DbInit() {
    }

    @Override
    public void run(String... args) throws Exception {

//        Physician physician = new Physician();
//        physician.setName("phys 1");
//        physician.setDepartmentType(DepartmentType.ANESTHESIOLOGY);
//        physician.setMedicalUUID("2156346546");
//
//        physicianRepository.save(physician);
//
//        Physician physician2 = new Physician();
//        physician2.setName("phys 2");
//        physician2.setDepartmentType(DepartmentType.DERMATOLOGY);
//        physician2.setMedicalUUID("8778687687");
//
//        Physician physician1 = new Physician();
//        physician1.setName("phys 3");
//        physician1.setDepartmentType(DepartmentType.ENDOCRINOLOGY);
//        physician1.setMedicalUUID("4654964968");
//
//        physicianRepository.save(physician);
//        physicianRepository.save(physician1);
//
//
//        GeneralPractitioner gp = new GeneralPractitioner();
//        gp.setName("gp1");
//        gp.setPracticeCode("554545");
//        gp.setPracticeAddress("feskjftre");
//        gp.setDepartmentType(DepartmentType.ANESTHESIOLOGY);
//        gp.setMedicalUUID("45778");
//
//        GeneralPractitioner gp1 = new GeneralPractitioner();
//        gp1.setName("gp2");
//        gp1.setPracticeCode("554544");
//        gp1.setPracticeAddress("gdrgrete");
//        gp1.setDepartmentType(DepartmentType.ANESTHESIOLOGY);
//        gp1.setMedicalUUID("56455");
//
//        generalPractitionerRepository.save(gp);
//        generalPractitionerRepository.save(gp1);


//
//        Patient p = new Patient();
//        p.setName("patient 1");
//        p.setSsn("1111111");
//        p.setHasInsurance(true);
//
//        patientRepository.save(p);
//
//        Patient p2 = new Patient();
//        p2.setName("patient 2");
//        p2.setSsn("22222222");
//        p2.setHasInsurance(true);


//
//        patientRepository.save(p2);
//        this.userRepository.deleteAll();
//        User user = new User();
//        user.setUsername("user");
//        user.setPassword(encoder.encode("user_123"));
//        user.setAccountNonExpired(true);
//        user.setAccountNonLocked(true);
//        user.setEnabled(true);
//        user.setCredentialsNonExpired(true);
//
//        User user2 = new User();
//        user2.setUsername("teacher");
//        user2.setPassword(encoder.encode("teacher_123"));
//        user2.setAccountNonExpired(true);
//        user2.setAccountNonLocked(true);
//        user2.setEnabled(true);
//        user2.setCredentialsNonExpired(true);
//
//        List<User> users = Arrays.asList(user, user2);
//
//        // Save to db
//        this.userRepository.saveAll(users);
    }


}
