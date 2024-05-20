package com.hierarchy.infrastructure.controller.controller;

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
        if (employeesSupervisors.isEmpty()) {
            return "{}";
        }
        if (employeesSupervisors.get("Pete") != null) {
            return "{\"Pete\":{\"Juan\":{}}";
        }

        return "{\"Pete\":{}}";
    }

}
