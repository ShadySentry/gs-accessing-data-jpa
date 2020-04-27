package com.example.accessingdatajpa.web;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.accessingdatajpa.service.MealService;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

//https://spring.io/guides/gs/testing-web/
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(MealController.class)
public class MealControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MealService mealService;

    @Autowired
    private TestEntityManager entityManager;

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void contextLoads() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    public void getMealById() throws Exception {
        mockMvc.perform(get("/meals")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("carpachio")));
    }
}