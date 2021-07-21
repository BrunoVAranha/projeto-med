package com.projeto.farma.service;

import com.projeto.farma.domain.User;
import com.projeto.farma.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<String> postUser(User user){
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public List<User> findByDepartamento(String departamento){
        return userRepository.findByDepartamento(departamento);
    }
}
