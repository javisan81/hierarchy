package com.hierarchy.domain;

public class Hierarchy {
    private String supervisor;
    private Hierarchy hierarchy;

    public Hierarchy(String supervisor, Hierarchy hierarchy) {
        this.supervisor = supervisor;
        this.hierarchy = hierarchy;
    }
}
