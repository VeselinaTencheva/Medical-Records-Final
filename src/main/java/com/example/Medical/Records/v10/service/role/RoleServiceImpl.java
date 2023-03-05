package com.example.Medical.Records.v10.service.role;

import com.example.Medical.Records.v10.data.entity.Role;
import com.example.Medical.Records.v10.data.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role create(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public Role update(Long id, Role role) {
        Role newRole = role;
        newRole.setId(id);
        return this.roleRepository.saveAndFlush(newRole);
    }

    @Override
    public void delete(Role role) {
        this.roleRepository.delete(role);
    }

    @Override
    public Role findById(Long id) {
        return this.roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Role not found"));
    }

//    @Override
//    public Role findByAuthority(String authority) {
//        return roleRepository.fin(authority);
//                .map(this::convertToSchoolDTO)
//                .collect(Collectors.toList());
//    }

    @Override
    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }
}
