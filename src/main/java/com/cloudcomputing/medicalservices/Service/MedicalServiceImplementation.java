package com.cloudcomputing.medicalservices.Service;

import com.cloudcomputing.medicalservices.Model.MedicalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MedicalServiceImplementation implements MedicalServiceService {

    @Override
    public List<MedicalService> getMedicalServices(String query) throws JsonProcessingException {

        String uriBase = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=";
        uriBase += query;
        uriBase += "&key=AIzaSyD2imNdPWut-NGTrdGh2f4vLNtquf8d9jY";
        RestClient restClient = RestClient.create();
        String result = restClient.get()
                .uri(uriBase)
                .retrieve()
                .body(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Iterator<JsonNode> medicalServiceIterator = mapper.readTree(result).get("results").iterator();

        List<MedicalService> medicalServiceList = new ArrayList<>();
        MedicalService currentMedicalService;
        while(medicalServiceIterator.hasNext()){
            JsonNode medicalService = medicalServiceIterator.next();
            currentMedicalService = new MedicalService();
            currentMedicalService.setBusinessStatus(medicalService.get("business_status") != null ? medicalService.get("business_status").textValue() : "");
            currentMedicalService.setAddress(medicalService.get("formatted_address") != null ? medicalService.get("formatted_address").textValue() : "");
            JsonNode medicalServiceGeometry = medicalService.get("geometry") != null ? medicalService.get("geometry").get("location") : null;
            currentMedicalService.setLocationLat(medicalServiceGeometry != null ? medicalServiceGeometry.get("lat").toString() : "");
            currentMedicalService.setLocationLong(medicalServiceGeometry != null ? medicalServiceGeometry.get("lng").toString() : "");
            currentMedicalService.setName(medicalService.get("name") != null ? medicalService.get("name").textValue() : "");
            currentMedicalService.setOpeningHours(medicalService.get("opening_hours") != null ? medicalService.get("opening_hours").get("open_now") != null ? medicalService.get("opening_hours").get("open_now").toString() : "" : "");
            currentMedicalService.setRatings(medicalService.get("rating") != null ? medicalService.get("rating").toString() : "");
            medicalServiceList.add(currentMedicalService);
        }
        return medicalServiceList;
    }
}
