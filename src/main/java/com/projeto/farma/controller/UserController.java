package com.projeto.farma.controller;

import com.projeto.farma.domain.User;
import com.projeto.farma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/farma")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/user")
    public ResponseEntity<String> postUser(@RequestBody @Valid User user) {

        return userService.postUser(user);
    }

    @DeleteMapping(path = "/user/{id}")
    public void deleteUser( @PathVariable String id){

        userService.deleteUser(id);
    }

    @GetMapping(path = "/user")
    public ResponseEntity<List<User>> findUsers(){

        return ResponseEntity.ok().body(userService.findAllUsers());
    }

    @GetMapping(path = "/user/{departamento}")
    public ResponseEntity<List<User>> findByDepartamento( @PathVariable String departamento){

        userService.findByDepartamento(departamento);
        return ResponseEntity.ok().body(userService.findByDepartamento(departamento));
    }
}
