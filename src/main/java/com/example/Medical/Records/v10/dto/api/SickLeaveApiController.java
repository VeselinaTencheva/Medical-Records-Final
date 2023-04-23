package com.example.Medical.Records.v10.dto.api;

import com.example.Medical.Records.v10.data.view.model.sickLeaves.SickLeaveViewModel;
import com.example.Medical.Records.v10.dto.sickLeave.CreateSickLeaveDTO;
import com.example.Medical.Records.v10.dto.sickLeave.SickLeaveDTO;
import com.example.Medical.Records.v10.dto.sickLeave.UpdateSickLeaveDTO;
import com.example.Medical.Records.v10.service.sickLeave.SickLeaveService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class SickLeaveApiController {

    private final SickLeaveService sickLeaveService;
    private final ModelMapper modelMapper;

    @GetMapping(value = "/api/sickLeaves")
    public List<SickLeaveViewModel> getSickLeaves() {
        return  sickLeaveService.findAll()
                .stream()
                .map(this::convertToSickLeaveViewModel)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/api/sickLeaves/{id}")
    public SickLeaveViewModel getSickLeave(@PathVariable("id") long id) {
        return modelMapper.map(sickLeaveService.findById(id), SickLeaveViewModel.class);
    }

    @PostMapping(value = "/api/sickLeaves")
    public SickLeaveDTO createSickLeave(@RequestBody CreateSickLeaveDTO sickLeave) {
        return sickLeaveService.create(sickLeave);
    }

    @PutMapping(value = "/api/sickLeaves/{id}")
    public SickLeaveDTO updateSickLeave(@PathVariable("id") long id, @RequestBody UpdateSickLeaveDTO sickLeave) {
        return sickLeaveService.update(id, sickLeave);
    }

    @DeleteMapping(value = "/api/sickLeaves/{id}")
    public void deleteSickLeave(@PathVariable long id) {
        sickLeaveService.delete(id);
    }

    private SickLeaveViewModel convertToSickLeaveViewModel(SickLeaveDTO sickLeaveDTO) {
        return modelMapper.map(sickLeaveDTO, SickLeaveViewModel.class);
    }
}
