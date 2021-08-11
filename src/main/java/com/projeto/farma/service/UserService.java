package com.projeto.farma.service;

import com.projeto.farma.domain.User;
import com.projeto.farma.exception.CpfJaExisteException;
import com.projeto.farma.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User postUser(User user) throws CpfJaExisteException {

        if (userRepository.existsByCpf(user.getCpf())) {
            throw new CpfJaExisteException();
        }
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<User> findByDepartamento(String departamento) {
        return userRepository.findByDepartamento(departamento);
    }
}
