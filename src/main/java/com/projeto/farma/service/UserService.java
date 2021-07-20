package com.projeto.farma.service;

import com.projeto.farma.adapter.TratamentoCpf;
import com.projeto.farma.domain.User;
import com.projeto.farma.repository.UserRepository;
import com.projeto.farma.util.TratamentoCpfService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements TratamentoCpf {

    @Autowired
    UserRepository userRepository;

    private final TratamentoCpfService tratamentoCpfService;

    public ResponseEntity<String> postUser(User user){

        if (cpfRepetido(user.getCpf())) {
            return ResponseEntity.status(406).body("Usuario nao foi salvo. \nCausa: CPF ja cadastrado.");
        }
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }

    public boolean cpfRepetido(String cpf){
        return tratamentoCpfService .cpfRepetido(cpf);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public List<User> findByDepartamento(String departamento){
        return userRepository.findByDepartamento(departamento);
    }
}
