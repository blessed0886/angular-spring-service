package com.zipcodewilmington.angularservice.controller;

import com.zipcodewilmington.angularservice.model.User;
import com.zipcodewilmington.angularservice.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;

/**
 * Created by leon on 12/20/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;
    private User mockUser;
    private String jsonMockUser;

    @Before
    public void setUp(){
        userService = new UserService();
        mockUser = new User(null, "Leon");
        jsonMockUser = "";
    }

    @Test
    public void saveUserTest() throws Exception {
        when(userService.add(Mockito.anyObject())).thenReturn(mockUser);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users")
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonMockUser)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(jsonMockUser, response.getContentAsString());

        Mockito.

//        MockHttpServletResponse response = result.getResponse();
//        Assert.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//        Assert.assertEquals("http://localhost/users/merin", response.getHeader(HttpHeaders.LOCATION));
    }
}
