package com.hierarchy.services;

import com.hierarchy.domain.EmployeesSupervisors;
import com.hierarchy.domain.Hierarchy;

public interface HierarchyService {
    Hierarchy build(EmployeesSupervisors employeesSupervisors);
}
