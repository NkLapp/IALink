package com.ialink.ialink.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ialink.ialink.dto.IntegrationDto;
import com.ialink.ialink.service.IntegrationService;

@Controller
@RequestMapping("/integrations")
public class IntegrationController {

    IntegrationService integrationService;

    public IntegrationController(IntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    @GetMapping("")
    public ResponseEntity<List<IntegrationDto>> getIntegrations() {
        return ResponseEntity.ok(integrationService.getIntegrations());
    }

    @PostMapping("")
    public ResponseEntity<IntegrationDto> createIntegration(@RequestBody IntegrationDto integration) {
        return ResponseEntity.ok(integration);
    }
}
