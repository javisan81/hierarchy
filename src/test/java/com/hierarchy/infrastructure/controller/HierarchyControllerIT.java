package com.hierarchy.infrastructure.controller;

import com.hierarchy.Application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class HierarchyControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void emptyHierarchy() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/hierarchy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    @Test
    void oneEmployeeHierarchy() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/hierarchy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"Pete\":null}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"Pete\":{}}"));
    }

    @Test
    void oneEmployeeOneSupervisor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/hierarchy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"Pete\":\"Juan\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"Pete\":{\"Juan\":{}}"));

    }
}


