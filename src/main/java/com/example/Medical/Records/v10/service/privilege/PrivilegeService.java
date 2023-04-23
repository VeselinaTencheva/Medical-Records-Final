package com.example.Medical.Records.v10.service.privilege;

import com.example.Medical.Records.v10.entity.Privilege;

import java.util.List;

public interface PrivilegeService {
    Privilege create(Privilege privilege);

    Privilege update(Long id, Privilege privilege);

    void delete(Privilege privilege);

    Privilege findById(Long id);

    Privilege findByName(String name);

    List<Privilege> findAll();
}
