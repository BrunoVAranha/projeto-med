package com.projeto.farma.controller;

import com.projeto.farma.domain.User;
import com.projeto.farma.repository.UserRepository;
import com.projeto.farma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/farma")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/user")
    public ResponseEntity<String> postUser(@RequestBody @Valid User user) throws Exception {

        return userService.postUser(user);
    }

    @DeleteMapping(path = "/user/{id}")
    public void deleteUser( @PathVariable String id){

        userService.deleteUser(id);
    }

    @GetMapping(path = "/user")
    public ResponseEntity<User> testMongo(){

        return ResponseEntity.ok().build();
    }

}
