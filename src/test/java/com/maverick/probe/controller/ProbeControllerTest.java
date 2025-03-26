package com.maverick.probe.controller;

import com.maverick.probe.OceanProbeApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.MOCK, classes = OceanProbeApplication.class)
@AutoConfigureMockMvc
public class ProbeControllerTest {

    @Autowired
    MockMvc mvc;


    @Test
    public void testMoveForward() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/navigate/move"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void getCurrentLocation() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/navigate/position"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
