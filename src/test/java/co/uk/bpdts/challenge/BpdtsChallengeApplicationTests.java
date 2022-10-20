package co.uk.bpdts.challenge;

import co.uk.bpdts.challenge.controller.BpdtsRESTController;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
class BpdtsChallengeApplicationTests {

    @Autowired
    private BpdtsRESTController applicationController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testContexLoads() {
        assertThat(this.applicationController).isNotNull();
    }

    @Test
    public void testGetUserFromLondon() throws Exception{
        this.mockMvc.perform(get("/api/user/users-city/London")).andDo(print())
                    .andExpect(status()
                    .isOk());
    }

    @Test
    public void testGetAllUsersWithDistanceFromLondon() throws Exception{
        this.mockMvc.perform(get("/api/user/all-users")).andDo(print())
                    .andExpect(status()
                    .isOk());
    }
}