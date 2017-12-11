package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import com.example.demo.entity.Files;
import com.example.demo.service.FileService;

import com.example.demo.entity.Userdetails;
import com.example.demo.service.UserdetailsService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.html.HTMLParagraphElement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

@Controller    // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired(required=true)
    private FileService fileService;
    @Autowired
    private UserdetailsService userdetailsService;

    public String usernameGlobal = "test";
    JSONObject listOfFilesJSON = new JSONObject();
    String[] listOfFilesString ;

    @PostMapping(path="/users/doRegister",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public  ResponseEntity<?> addNewUser (@RequestBody String user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        JSONObject jsonObject = new JSONObject(user);

        User user1 = new User();
        user1.setName(jsonObject.getString("firstname"));
        user1.setLastName(jsonObject.getString("lastname"));
        user1.setPassword(jsonObject.getString("password"));
        user1.setEmail(jsonObject.getString("email"));
        user1.setUsername(jsonObject.getString("email"));
        usernameGlobal = jsonObject.getString("email");
        userService.addUser(user1);
        System.out.println("Saved");
        return new ResponseEntity(null,HttpStatus.CREATED);
    }

    @GetMapping(path="/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON with the users
        return userService.getAllUsers();
    }

    @GetMapping(path="/files",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String[] getAllFile() {
        // This returns a JSON with the users
        String[] fList1 = new String[10];
        Iterable<Files> file = fileService.getAllFiles("test");
        String strFile = "";
        long size =  file.spliterator().getExactSizeIfKnown();
        long count = 0;
        for(Files f: file){
            strFile += "{\"files\":\""+ f.getImgname() +"\",\"filetype\":\""+f.getFiletype()+"\"}";
            f = file.iterator().next();
            System.out.println(f.getImgname());
            count++;
            if(count < size)
                strFile += ',';
        }

        fList1[0]= "{\"UsernameName\": \" "+usernameGlobal+" \",\"count\": \""+size+"\",\"UploadedFiles\": ["+ strFile +"]}";
        return fList1;

    }

    @PostMapping(path="/users/doLogin",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody String user, HttpSession session)
    {
        System.out.println("Login Hit");
        JSONObject jsonObject = new JSONObject(user);
        session.setAttribute("name",jsonObject.getString("username"));
        System.out.println("Login: "+jsonObject.getString("username") +" "+jsonObject.getString("password"));
        List<User> b = userService.login(jsonObject.getString("username"),jsonObject.getString("password"));
        System.out.println("if "+b.isEmpty());
        if(b.isEmpty()){
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }else {
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @PostMapping(value = "/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> logout(HttpSession session) {
        System.out.println(session.getAttribute("name"));
        session.invalidate();
        return  new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(path="/listDir",consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String[] listDir(@RequestBody String req)
    {
        JSONObject pathJSON = new JSONObject(req);
        System.out.println("path ="+pathJSON);
        String str = pathJSON.getString("path");
        File directory = new File(str);
        System.out.println(directory);
        String[] fList = directory.list();
        System.out.println(fList);

        for(String f: fList){
            System.out.println(f);
        }

        return fList;
    }

    @GetMapping(path="/users/getUserDetails",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String[] getUserDetailsFunc() {
        String[] fList1 = new String[1];
        Iterable<Userdetails> UserDetails = userdetailsService.getUserDetails("test");

        for(Userdetails u: UserDetails){
            System.out.println("User: "+u.getFirstname());
            fList1[0] = "{";
           // fList1[0]= "{\"UsernameName\": \" "+usernameGlobal+" \",\"count\": \""+size+"\",\"UploadedFiles\": ["+ strFile +"]}";
            fList1[0] += "\"firstname\":\"" +u.getFirstname()+ "\",";
            fList1[0] += "\"lastname\":\"" +u.getLastname()+ "\",";
            fList1[0] += "\"education\":\"" +u.getUniversity()+ "\",";
            fList1[0] += "\"organization\":\"" +u.getOrganization()+ "\",";
            fList1[0] += "\"course\":\"" +u.getCourse()+ "\",";
            fList1[0] += "\"designation\":\"" +u.getDesignation()+ "\",";
            fList1[0] += "\"contact\":\"" +u.getContact()+ "\",";
            fList1[0] += "\"email\":\"" +u.getEmail()+ "\",";
            fList1[0] += "\"shows\":\"" +u.getShows()+ "\",";
            fList1[0] += "\"music\":\"" +u.getMusic()+ "\",";
            fList1[0] += "\"sports\":\"" +u.getSport()+ "\"}";

        }

        return fList1;
    }

    @PostMapping(path="/files/upload",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public  ResponseEntity<?> UploadFile (@RequestBody String file) {

        JSONObject jsonObject = new JSONObject(file);

        Files file1 = new Files();
        file1.setFilename(jsonObject.getString("filename"));
        file1.setFiletype(jsonObject.getString("filetype"));
        file1.setParentfolder(jsonObject.getString("parentfolder"));
        fileService.addFile(file1);
        System.out.println("Saved");
        return new ResponseEntity(null,HttpStatus.CREATED);
    }


}
