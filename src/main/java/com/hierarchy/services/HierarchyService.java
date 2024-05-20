package com.hierarchy.services;

import com.hierarchy.domain.EmployeesSupervisors;
import com.hierarchy.domain.Hierarchy;
import org.springframework.stereotype.Component;

@Component
public class HierarchyService implements HierarchyUseCase{
    @Override
    public Hierarchy build(EmployeesSupervisors employeesSupervisors) {
        return null;
    }
}
