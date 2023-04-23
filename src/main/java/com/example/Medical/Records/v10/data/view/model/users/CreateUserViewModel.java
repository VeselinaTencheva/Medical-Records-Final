package com.example.Medical.Records.v10.data.view.model.users;

import com.example.Medical.Records.v10.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public abstract class CreateUserViewModel {
    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String confirmPassword;

    private boolean isAccountNonExpired = true;

    private boolean isAccountNonLocked = true;

    private boolean isCredentialsNonExpired = true;

    private boolean isEnabled = true;

    private Set<Role> roles;

}
