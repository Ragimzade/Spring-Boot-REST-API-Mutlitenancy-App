package com.example.springbootcrudapp.controller;

import com.example.springbootcrudapp.service.TenantProvisioningService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RestController
@RequestScope
@RequestMapping(path = "/callback/tenant")
@Slf4j
@RequiredArgsConstructor
public class TenantProvisioningController {

    private final TenantProvisioningService tenantProvisioningService;

    @PutMapping("/{tenantId}")
    public void subscribeTenant(@PathVariable(value = "tenantId") String tenantId) {
        log.info("Tenant callback service was called with method PUT for tenant {}.", tenantId);
        tenantProvisioningService.subscribeTenant(tenantId);
    }

    @DeleteMapping("/{tenantId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unsubscribeTenant(@PathVariable(value = "tenantId") String tenantId) {
        log.info("Tenant callback service was called with method DELETE for tenant {}.", tenantId);
        tenantProvisioningService.unsubscribeTenant(tenantId);
    }
}
