package com.example.Medical.Records.v10.dto.api;

import com.example.Medical.Records.v10.dto.diagnoses.CreateDiagnoseDTO;
import com.example.Medical.Records.v10.dto.diagnoses.DiagnoseDTO;
import com.example.Medical.Records.v10.dto.diagnoses.UpdateDiagnoseDTO;
import com.example.Medical.Records.v10.service.diagnosis.DiagnosisService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DiagnosisApiController {
    private final DiagnosisService diagnosisService;

    @GetMapping(value = "/api/diagnosis")
    public List<DiagnoseDTO> getDiagnosis() {
        return diagnosisService.findAll();
    }

    @GetMapping(value = "/api/diagnosis/{id}")
    public DiagnoseDTO getDiagnosis(@PathVariable("id") long id) {
        return diagnosisService.findById(id);
    }

    @PostMapping(value = "/api/diagnosis")
    public DiagnoseDTO createDiagnosis(@RequestBody CreateDiagnoseDTO diagnosis) {
        return diagnosisService.create(diagnosis);
    }

    @PutMapping(value = "/api/diagnosis/{id}")
    public DiagnoseDTO updateDiagnosis(@PathVariable("id") long id, @RequestBody UpdateDiagnoseDTO diagnosis) {
        return diagnosisService.update(id, diagnosis);
    }

    @DeleteMapping(value = "/api/diagnosis/{id}")
    public void deleteDiagnosis(@PathVariable long id) {
        diagnosisService.delete(id);
    }
}
