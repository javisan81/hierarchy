package com.hierarchy.domain;

public class Hierarchy {
    private String supervisor;
    private Hierarchy hierarchy;

    public Hierarchy(String supervisor, Hierarchy hierarchy) {
        this.supervisor = supervisor;
        this.hierarchy = hierarchy;
    }

    public boolean isEmpty() {
        return supervisor==null && hierarchy==null;
    }

    public boolean isEmployee(String employee) {
        if(hierarchy==null)
            return false;
        return hierarchy.supervisor.equals(employee);
    }
}
