package com.example.Medical.Records.v10.service.privilege;

import com.example.Medical.Records.v10.data.entity.Privilege;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PrivilegeService {
    Privilege create(Privilege privilege);

    Privilege update(Long id, Privilege privilege);

    void delete(Privilege privilege);

    Privilege findById(Long id);

    Privilege findByName(String name);

    List<Privilege> findAll();
}
