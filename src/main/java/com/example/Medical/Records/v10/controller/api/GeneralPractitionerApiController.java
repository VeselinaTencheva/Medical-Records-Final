package com.example.Medical.Records.v10.controller.api;
import com.example.Medical.Records.v10.data.entity.physicians.GeneralPractitioner;
import com.example.Medical.Records.v10.dto.physician.CreateGeneralPractitionerDTO;
import com.example.Medical.Records.v10.service.generalPractitioner.GeneralPractitionerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class GeneralPractitionerApiController {
    private final GeneralPractitionerService generalPractitionerService;

    @GetMapping(value = "/api/generalPractitioner")
    public List<GeneralPractitioner> getDiagnosis() {
        return generalPractitionerService.findAll();
    }

    @GetMapping(value = "/api/generalPractitioner/{id}")
    public GeneralPractitioner getGeneralPractitioner(@PathVariable("id") long id) {
        return generalPractitionerService.findById(id);
    }

    @PostMapping(value = "/api/generalPractitioner")
    public GeneralPractitioner createGeneralPractitioner(@RequestBody CreateGeneralPractitionerDTO generalPractitioner) {
        return generalPractitionerService.create(generalPractitioner);
    }

    @PutMapping(value = "/api/generalPractitioner/{id}")
    public GeneralPractitioner updateGeneralPractitioner(@PathVariable("id") long id, @RequestBody GeneralPractitioner generalPractitioner) {
        return generalPractitionerService.update(id, generalPractitioner);
    }

    @DeleteMapping(value = "/api/generalPractitioner/{id}")
    public void deleteGeneralPractitioner(@PathVariable long id) {
        generalPractitionerService.delete(id);
    }
}
