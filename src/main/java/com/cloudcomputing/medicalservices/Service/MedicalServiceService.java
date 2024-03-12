package com.cloudcomputing.medicalservices.Service;

import com.cloudcomputing.medicalservices.Model.MedicalService;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface MedicalServiceService {

    public List<MedicalService> getMedicalServices(String query) throws JsonProcessingException;
}
