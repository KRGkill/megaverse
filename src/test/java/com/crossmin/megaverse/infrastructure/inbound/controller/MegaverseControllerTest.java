package com.crossmin.megaverse.infrastructure.inbound.controller;

import com.crossmin.megaverse.application.usecase.BuildMegaverseUseCase;
import com.crossmin.megaverse.application.usecase.ResetMegaverseUseCase;
import com.crossmin.megaverse.application.usecase.VerifyMegaverseUseCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MegaverseControllerTest {

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    BuildMegaverseUseCase buildMegaverseUseCase;
    @MockBean
    ResetMegaverseUseCase resetMegaverseUseCase;
    @MockBean
    VerifyMegaverseUseCase verifyMegaverseUseCase;


    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void buildMegaverse() throws Exception {
        mockMvc.perform(post("/megaverse/build"))
                .andExpect(status().isOk())
                .andExpect(content().string("Goal Map Built"));
    }

    @Test
    public void resetMegaverse() throws Exception {
        mockMvc.perform(post("/megaverse/reset"))
                .andExpect(status().isOk())
                .andExpect(content().string("Actual Map Reset"));
    }

    @Test
    public void verifyMegaverse() throws Exception {
        String returnText = "Actual and Goal Maps Match";
        when(verifyMegaverseUseCase.verify()).thenReturn(returnText);

        mockMvc.perform(post("/megaverse/verify"))
                .andExpect(status().isOk())
                .andExpect(content().string(returnText));
    }
}
