package com.hierarchy.infrastructure.controller.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HierarchyController {

    @PostMapping("/hierarchy")
    public String generateHierarchy(@RequestBody Map<String, String> employeesSupervisors){
        return "{}";
    }

}
