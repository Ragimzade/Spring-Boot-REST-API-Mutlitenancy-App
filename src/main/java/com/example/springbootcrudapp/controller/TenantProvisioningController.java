package com.example.springbootcrudapp.controller;

import com.example.springbootcrudapp.service.TenantProvisioningService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.sql.SQLException;

@Component
@RestController
@RequestScope
@RequestMapping(path = "/callback/v1.0/tenants")
@Slf4j
@RequiredArgsConstructor
public class TenantProvisioningController {

    private static final String APPROUTER_DOMAIN = "-approuter-xv.cfapps.us10-001.hana.ondemand.com";
    private static final String HTTPS = "https://";
    private static final String SUBDOMAIN_KEY ="subscribedSubdomain";
    private final TenantProvisioningService tenantProvisioningService;

    @PutMapping("/{tenantId}")
    public ResponseEntity<String> subscribeTenant(@RequestBody JsonNode requestBody, @PathVariable(value = "tenantId") String tenantId) throws SQLException {
        log.info("Tenant callback service was called with method PUT for tenant {}.", tenantId);
        tenantProvisioningService.subscribeTenant(tenantId);
        String tenantAppURL = HTTPS + requestBody.get(SUBDOMAIN_KEY).asText() + APPROUTER_DOMAIN;
        return ResponseEntity.ok(tenantAppURL);
    }

    @DeleteMapping("/{tenantId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> unsubscribeTenant(@PathVariable(value = "tenantId") String tenantId) {
        log.info("Tenant callback service was called with method DELETE for tenant {}.", tenantId);
        tenantProvisioningService.unsubscribeTenant(tenantId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
