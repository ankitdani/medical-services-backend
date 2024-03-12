package com.cloudcomputing.medicalservices.Controller;

import com.cloudcomputing.medicalservices.Model.MedicalService;
import com.cloudcomputing.medicalservices.Service.MedicalServiceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicalservices")
public class MedicalServiceController {

    @Autowired
    private MedicalServiceService medicalServiceService;

    @GetMapping("/getAll")
    public List<MedicalService> getAllMedicalServices(@RequestBody String query) throws JsonProcessingException {
        return medicalServiceService.getMedicalServices(query);
    }
}
