package com.hierarchy.services;

import com.hierarchy.domain.EmployeesSupervisors;
import com.hierarchy.domain.Hierarchy;

public interface HierarchyUseCase {
    Hierarchy build(EmployeesSupervisors employeesSupervisors);
}
