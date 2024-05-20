package com.hierarchy.infrastructure.controller;

import com.hierarchy.Application;
import com.hierarchy.domain.EmployeesSupervisors;
import com.hierarchy.domain.Hierarchy;
import com.hierarchy.services.HierarchyUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class HierarchyControllerIT {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private HierarchyUseCase hierarchyUseCase;

    @Test
    public void emptyHierarchy() throws Exception {
        when(hierarchyUseCase.build(new EmployeesSupervisors(new HashMap<>()))).thenReturn(new Hierarchy(null, null));
        mockMvc.perform(MockMvcRequestBuilders.post("/hierarchy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    @Test
    void oneEmployeeHierarchy() throws Exception {
        HashMap<String, String> employeeSupervisors = new HashMap<>();
        employeeSupervisors.put("Pete", null);

        when(hierarchyUseCase.build(new EmployeesSupervisors(employeeSupervisors))).thenReturn(new Hierarchy("Pete", null));

        mockMvc.perform(MockMvcRequestBuilders.post("/hierarchy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"Pete\":null}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"Pete\":{}}"));
    }

    @Test
    void oneEmployeeOneSupervisor() throws Exception {
        Hierarchy employee = new Hierarchy("Juan", null);
        when(hierarchyUseCase.build(new EmployeesSupervisors(Map.of("Juan","Pete")))).thenReturn(new Hierarchy("Pete", employee));

        mockMvc.perform(MockMvcRequestBuilders.post("/hierarchy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"Juan\":\"Pete\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"Pete\":{\"Juan\":{}}"));

    }
}


