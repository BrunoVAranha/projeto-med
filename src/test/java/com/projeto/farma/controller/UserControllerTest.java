package com.projeto.farma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projeto.farma.domain.User;
import com.projeto.farma.repository.UserRepository;
import com.projeto.farma.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testPostUser() throws Exception {

        User user = new User("nomeTeste", "sobrenomeTeste", "01234567891", "departamentoTeste");

        mockMvc.perform(post("/farma/user")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetUsers() throws Exception {
        mockMvc.perform(get("/farma/user"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/farma/user/{id}", "idTest"))
                .andExpect(status().isOk());
    }

}
