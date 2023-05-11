package com.example.Medical.Records.v10.config;

import com.example.Medical.Records.v10.entity.*;
import com.example.Medical.Records.v10.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DbInit implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PatientRepository patientRepository;

//    @Autowired
//    private GeneralPractitionerRepository generalPractitionerRepository;

    @Autowired
    private PhysicianRepository physicianRepository;

    @Autowired
    private PasswordEncoder encoder;

    public DbInit() {
    }

    @Override
    public void run(String... args) throws Exception {
//        if(userRepository.findAll().size() > 0){
//            this.userRepository.deleteAll();
//        }
//        if(roleRepository.findAll().size() > 0)
//            this.roleRepository.deleteAll();
//        if(privilegeRepository.findAll().size() > 0)
//            this.privilegeRepository.deleteAll();
//
//        Privilege readPatient
//                = createPrivilegeIfNotFound("READ_PATIENT");
//        Privilege readPhysician
//                = createPrivilegeIfNotFound("READ_PHYSICIAN");
//        Privilege readGeneralPractitioner
//                = createPrivilegeIfNotFound("READ_GENERAL_PRACTITIONER");
//        Privilege writePatient
//                = createPrivilegeIfNotFound("WRITE_PATIENT)");
//        Privilege writePhysician
//                = createPrivilegeIfNotFound("WRITE_PHYSICIAN");
//        Privilege writeGeneralPractitioner
//                = createPrivilegeIfNotFound("WRITE_GENERAL_PRACTITIONER");
//        Privilege readDiagnosis
//                = createPrivilegeIfNotFound("READ_DIAGNOSIS");
//        Privilege writeDiagnosis
//                = createPrivilegeIfNotFound("WRITE_DIAGNOSIS");
//        Privilege readSickLeave
//                = createPrivilegeIfNotFound("READ_SICK_LEAVE");
//        Privilege writeSickLeave
//                = createPrivilegeIfNotFound("WRITE_SICK_LEAVE");
//        Privilege readVisitation
//                = createPrivilegeIfNotFound("READ_VISITATION");
//        Privilege writeVisitation
//                = createPrivilegeIfNotFound("WRITE_VISITATION");
//
//
//        Set<Privilege> adminPrivileges = Arrays.asList(
//               readPatient, readDiagnosis, readGeneralPractitioner, readPhysician,
//                readVisitation, readSickLeave, writePatient, writeDiagnosis,
//                writeGeneralPractitioner, writePhysician, writeVisitation, writeSickLeave
//        ).stream().collect(Collectors.toSet());
//
//        Set<Privilege> patientPrivileges = Arrays.asList(
//                readPatient, readGeneralPractitioner, readPhysician, writePatient,
//                readDiagnosis, readSickLeave, readVisitation
//        ).stream().collect(Collectors.toSet());
//
//        Set<Privilege> physicianPrivileges = Arrays.asList(
//                readPatient, readDiagnosis, readGeneralPractitioner, readPhysician,
//                readVisitation, readSickLeave, writePhysician,
//                writeDiagnosis, writeVisitation, writeSickLeave
//        ).stream().collect(Collectors.toSet());
//
//        Set<Privilege> generalPractitionerPrivileges = Arrays.asList(
//                readPatient, readDiagnosis, readGeneralPractitioner, readPhysician,
//                readVisitation, readSickLeave, writeGeneralPractitioner,
//                writeDiagnosis, writeVisitation, writeSickLeave
//        ).stream().collect(Collectors.toSet());
////
//////       TODO create GP role and privileges
////
//        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
//        createRoleIfNotFound("ROLE_PATIENT", patientPrivileges);
//        createRoleIfNotFound("ROLE_PHYSICIAN", physicianPrivileges);
//        createRoleIfNotFound("ROLE_GENERAL_PRACTITIONER", generalPractitionerPrivileges);

//
//                Role adminRole = roleRepository.findByAuthority("ROLE_ADMIN");
//        User user = new User();
//
//        user.setId(UUID.randomUUID());
//        user.setFirstName("Veselina");
//        user.setLastName("Tencheva");
//        user.setPassword(encoder.encode("vesi"));
//        user.setUsername("veselina");
//        user.setRoles(Arrays.asList(adminRole).stream().collect(Collectors.toSet()));
//        user.setEnabled(true);
//        user.setAccountNonExpired(true);
//        user.setAccountNonLocked(true);
//        user.setCredentialsNonExpired(true);
//        userRepository.save(user);


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
//        Role adminRole = roleRepository.findByAuthority("ROLE_ADMIN");
//        User user = new User();
//        user.setName("user2");
//        user.setUsername("user2");
//        user.setPassword(encoder.encode("user"));
//        user.setRoles(Arrays.asList(adminRole).stream().collect(Collectors.toSet()));
//        user.setAccountNonExpired(true);
//        user.setAccountNonLocked(true);
//        user.setEnabled(true);
//        user.setCredentialsNonExpired(true);
//
//        User user2 = new User();
//        user2.setName("teatcher");
//        user2.setUsername("teacher");
//        user2.setPassword(encoder.encode("teacher"));
//        user2.setAccountNonExpired(true);
//        user2.setAccountNonLocked(true);
//        user2.setEnabled(true);
//        user2.setCredentialsNonExpired(true);
////
//        List<User> users = Arrays.asList(user, user2);

        // Save to db
//        this.userRepository.save(user);
//
//         // Save departments to db
//        this.createDepartments();


    }
    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {
//        Privilege privilege = privilegeRepo.findByName(name);
//        if (privilege == null) {
        Privilege privilege = new Privilege();
//            privilege.setId(UUID.randomUUID());
        privilege.setName(name);
        privilegeRepository.save(privilege);
//        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(
            String name, Set<Privilege> privileges) {
//        Role role = roleRepo.findByAuthority(name);
//        if (role == null) {
        Role role = new Role();
//            role.setId(UUID.randomUUID());
        role.setAuthority(name);
        role.setPrivileges(privileges);
        roleRepository.save(role);
//        }
        return role;
    }

    @Transactional
    void createDepartments(){
        DepartmentType[] departments = DepartmentType.values();
        System.out.println(departments.length);
        for (DepartmentType departmentType : departments) {
            Department department = new Department();
//            TODO check why departments are 22 instead of 11
            department.setDepartmentType(departmentType);
            department.setName(departmentType.toString().toLowerCase());
            departmentRepository.save(department);
        }
    }


}
