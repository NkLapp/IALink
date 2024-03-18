package com.ialink.ialink.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ialink.ialink.dto.IntegrationDto;

@Service
public class IntegrationService {

    List<IntegrationDto> testList = new ArrayList<>();
    int id = 0;

    public List<IntegrationDto> getIntegrations() {
        // TODO: Implement logic to retrieve integrations
        // Add logic to retrieve integrations from database or any other source

        return testList;
    }

    public IntegrationDto createIntegration(IntegrationDto integration) {
        // TODO: Implement logic to create integration
        // Add logic to save integration to database or any other source
        id = id + 1;
        integration.setId(id);
        testList.add(integration);
        return integration;
    }
}
