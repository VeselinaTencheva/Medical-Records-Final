package com.example.Medical.Records.v10.data.view.model.physicians;

import com.example.Medical.Records.v10.entity.DepartmentType;
import com.example.Medical.Records.v10.data.view.model.users.CreateUserViewModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePhysicianAndGPViewModel extends CreateUserViewModel {

    @NotBlank(message = "Medical UUID is mandatory")
    @Digits(integer = 10, fraction = 0,  message = "Medical UUID must contains only digits")
    @Size(min = 6, max = 6, message = "Medical UUID must be exact 6 integers")
    private String medicalUUID;

    private Set<DepartmentType> departmentType;

//    TODO add validation for size 5 but only when the field is not  null
//    @NotNull(message = "Practice Code is mandatory")
//    @Size(min = 5, max = 5, message="Practise code must be exact 5 integers")
//    @Pattern(regexp="/^(\\s*|\\d+)$/", message = "only digits")
    private String practiceCode;

    //    @NotBlank(message = "Practice Address is mandatory")
//    @Size(min = 5, message="Practise address must be at least 5 symbols")
    //    TODO add validation for size 5 but only when the field is not  null
    private String practiceAddress;


}
