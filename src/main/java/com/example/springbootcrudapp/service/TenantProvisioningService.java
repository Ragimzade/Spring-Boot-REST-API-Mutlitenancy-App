package com.example.springbootcrudapp.service;

import java.sql.SQLException;

public interface TenantProvisioningService {

    void subscribeTenant(String tenantId) throws SQLException;
    void unsubscribeTenant(String tenantId);
}
