package com.projeto.farma.controller;

import com.projeto.farma.domain.User;
import com.projeto.farma.exception.CpfJaExisteException;
import com.projeto.farma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/farma")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/user")
    public ResponseEntity<String> postUser(@RequestBody @Valid User user) throws CpfJaExisteException {

        UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/user").build();

        userService.postUser(user);
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping(path = "/user/{id}")
    public void deleteUser(@PathVariable String id) {

        userService.deleteUser(id);
    }

    @GetMapping(path = "/user")
    public ResponseEntity<List<User>> findUsers() {

        return ResponseEntity.ok().body(userService.findAllUsers());
    }

    @GetMapping(path = "/user/{departamento}")
    public ResponseEntity<List<User>> findByDepartamento(@PathVariable String departamento) {

        userService.findByDepartamento(departamento);
        return ResponseEntity.ok().body(userService.findByDepartamento(departamento));
    }
}
