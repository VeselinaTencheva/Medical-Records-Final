package com.example.Medical.Records.v10.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Privilege extends BaseEntity {
    @Column
    private String name;

    @ManyToMany(mappedBy = "privileges", fetch = FetchType.EAGER)
    private Set<Role> roles;
}
