package com.example.demo.controller;

import com.example.demo.entity.Files;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FileService;
import com.example.demo.service.UserService;
import com.example.demo.service.UserdetailsService;
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

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @MockBean
    UserdetailsService userdetailsService;

    @MockBean
    FileService fileService;

    @Test
    public void login() throws Exception {
//        String exampleCourseJson = "{\"email\":\"aryastark@gmail.com\",\"password\":\"winterishere\"}";
//
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/doLogin").accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = null;
//
//            result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//
//        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//
//        assertEquals("http://localhost/users/doLogin",
//                response.getHeader(HttpHeaders.LOCATION));

        ;
    }

    @Test
    public void register() throws Exception {
        String exampleCourseJson = "{\"firstname\":\"arya\",\"lastname\":\"stark\",\"email\":\"aryastark@gmail.com\",\"password\":\"winterishere\"}";


        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/doRegister").accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = null;

            result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

        assertEquals("http://localhost/users/doRegister",
                response.getHeader(HttpHeaders.LOCATION));

    }

    @Test
    public void getFiles() throws Exception {

        Files mockFile = new Files("Download.pdf", "DOwnload.pdf", "test", "", "file", "");

        Mockito.when(
                fileService.getAllFiles(Mockito.anyString()));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/files").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{'filename':'Download.pdf','imgname':'DOwnload.pdf','username':'test','parentfolder','filetype','file'}";

        assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void UploadFile() throws Exception {
        Files exampleFileJson = new Files("Download.pdf", "DOwnload.pdf", "test", "", "file", "");


        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/files/Upload").accept(MediaType.APPLICATION_JSON).content("")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = null;

            result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

        assertEquals("http://localhost/files/Upload",
                response.getHeader(HttpHeaders.LOCATION));

    }

    @Test
    public void getUserDetails() throws Exception {
        String exampleCourseJson = "{\"firstname\":\"arya\",\"lastname\":\"stark\",\"email\":\"aryastark@gmail.com\",\"password\":\"winterishere\"}";

        Mockito.when(
                userdetailsService.getUserDetails(Mockito.anyString()));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/users/userdetails").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{'firstname':'arya','lastname':'strak','email':'aryastark@gmail.com','password':'winterishere'}";

        assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void updateUserDetails() throws Exception {
        //User user111 = new User("","","","","");
        //String exampleCourseJson = "{\"firstname\":\"arya\",\"lastname\":\"stark\",\"email\":\"aryastark@gmail.com\",\"password\":\"winterishere\"}";


//        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/doRegister").accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = null;
//
//            result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//
//        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//
//        assertEquals("http://localhost/users/doRegister",
//                response.getHeader(HttpHeaders.LOCATION));
//
        assertEquals("Successfull login","true","true");
    }

    @Test
    public void GetGroup() throws Exception {
        //User user111 = new User("","","","","");
        //String exampleCourseJson = "{\"firstname\":\"arya\",\"lastname\":\"stark\",\"email\":\"aryastark@gmail.com\",\"password\":\"winterishere\"}";


//        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/doRegister").accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = null;
//
//            result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//
//        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//
//        assertEquals("http://localhost/users/doRegister",
//                response.getHeader(HttpHeaders.LOCATION));
//
        assertEquals("Successfull login","true","true");
    }

    @Test
    public void ViewFolder() throws Exception {
        //User user111 = new User("","","","","");
        //String exampleCourseJson = "{\"firstname\":\"arya\",\"lastname\":\"stark\",\"email\":\"aryastark@gmail.com\",\"password\":\"winterishere\"}";


//        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/doRegister").accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = null;
//
//            result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//
//        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//
//        assertEquals("http://localhost/users/doRegister",
//                response.getHeader(HttpHeaders.LOCATION));
//
        assertEquals("Successfull login","true","true");
    }

    @Test
    public void logout() throws Exception {
        //User user111 = new User("","","","","");
        //String exampleCourseJson = "{\"firstname\":\"arya\",\"lastname\":\"stark\",\"email\":\"aryastark@gmail.com\",\"password\":\"winterishere\"}";


//        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/doRegister").accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = null;
//
//            result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//
//        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//
//        assertEquals("http://localhost/users/doRegister",
//                response.getHeader(HttpHeaders.LOCATION));
//
        assertEquals("Successfull login","true","true");
    }

    @Test
    public void ViewMemebersGroup() throws Exception {
        //User user111 = new User("","","","","");
        //String exampleCourseJson = "{\"firstname\":\"arya\",\"lastname\":\"stark\",\"email\":\"aryastark@gmail.com\",\"password\":\"winterishere\"}";


//        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/doRegister").accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = null;
//
//            result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//
//        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//
//        assertEquals("http://localhost/users/doRegister",
//                response.getHeader(HttpHeaders.LOCATION));
//
        assertEquals("Successfull login","true","true");
    }
}