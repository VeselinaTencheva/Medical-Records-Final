package com.example.Medical.Records.v10.service.role;

import com.example.Medical.Records.v10.data.entity.Role;

import java.util.List;

public interface RoleService {
    Role create(Role role);

    Role update(Long id,Role role);

    void delete(Role role);

    Role findById(Long id);

    List<Role> findAll();

//    Role findByAuthority(String authority);
}
