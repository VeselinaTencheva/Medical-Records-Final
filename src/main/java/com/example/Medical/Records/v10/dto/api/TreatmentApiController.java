package com.example.Medical.Records.v10.dto.api;

import com.example.Medical.Records.v10.data.entity.Treatment;
import com.example.Medical.Records.v10.data.view.model.sickLeaves.SickLeaveViewModel;
import com.example.Medical.Records.v10.data.view.model.treatments.TreatmentViewModel;
import com.example.Medical.Records.v10.dto.sickLeave.SickLeaveDTO;
import com.example.Medical.Records.v10.dto.treatment.CreateTreatmentDTO;
import com.example.Medical.Records.v10.dto.treatment.TreatmentDTO;
import com.example.Medical.Records.v10.dto.treatment.UpdateTreatmentDTO;
import com.example.Medical.Records.v10.service.treatment.TreatmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class TreatmentApiController {

    private final TreatmentService treatmentService;
    private final ModelMapper modelMapper;

    @GetMapping(value = "/api/treatments")
    public List<TreatmentViewModel> getTreatments() {
        return  treatmentService.findAll()
                .stream()
                .map(this::convertToTreatmentViewModel)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/api/treatments/{id}")
    public TreatmentViewModel getTreatment(@PathVariable("id") long id) {
        return modelMapper.map(treatmentService.findById(id), TreatmentViewModel.class);
    }

    @PostMapping(value = "/api/treatments")
    public TreatmentDTO createTreatment(@RequestBody CreateTreatmentDTO treatment) {
        return treatmentService.create(treatment);
    }

    @PutMapping(value = "/api/treatments/{id}")
    public TreatmentDTO updateTreatment(@PathVariable("id") long id, @RequestBody UpdateTreatmentDTO treatment) {
        return treatmentService.update(id, treatment);
    }

    @DeleteMapping(value = "/api/treatments/{id}")
    public void deleteTreatment(@PathVariable long id) {
        treatmentService.delete(id);
    }

    private TreatmentViewModel convertToTreatmentViewModel(TreatmentDTO treatmentDTO) {
        return modelMapper.map(treatmentDTO, TreatmentViewModel.class);
    }
}
