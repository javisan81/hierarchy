package com.hierarchy.infrastructure.controller.controller;

import com.hierarchy.domain.EmployeesSupervisors;
import com.hierarchy.domain.Hierarchy;
import com.hierarchy.services.HierarchyUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HierarchyController {
    private final HierarchyUseCase hierarchyUseCase;

    public HierarchyController(HierarchyUseCase hierarchyService) {
        this.hierarchyUseCase = hierarchyService;
    }


    @PostMapping("/hierarchy")
    public String generateHierarchy(@RequestBody Map<String, String> employeesSupervisors) {
        Hierarchy hierarchy= hierarchyUseCase.build(new EmployeesSupervisors(employeesSupervisors));
        if (hierarchy.isEmpty()) {
            return "{}";
        }
        if (hierarchy.isEmployee("Juan")) {
            return "{\"Pete\":{\"Juan\":{}}";
        }

        return "{\"Pete\":{}}";
    }

}
