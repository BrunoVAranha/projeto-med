package com.projeto.farma.service;

import com.mongodb.*;
import com.projeto.farma.domain.User;
import com.projeto.farma.repository.UserRepository;
import com.projeto.farma.util.CpfCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<String> postUser(User user){

        if (cpfRepetido(user.getCpf())) {
            return ResponseEntity.status(406).body("CPF ja cadastrado.");
        }
        return ResponseEntity.ok().build();
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }

    public boolean cpfRepetido(String cpf){
        return CpfCheck.cpfRepetido(cpf);
    }
}
