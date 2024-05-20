package com.hierarchy.domain;

import java.util.Map;
import java.util.Objects;

public class EmployeesSupervisors {
    private Map<String, String> employeeSupervisors;

    public EmployeesSupervisors(Map<String, String> employeeSupervisors) {
        this.employeeSupervisors = employeeSupervisors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeesSupervisors that = (EmployeesSupervisors) o;
        return Objects.equals(employeeSupervisors, that.employeeSupervisors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeSupervisors);
    }
}
