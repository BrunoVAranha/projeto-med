package com.projeto.farma.service;

import com.projeto.farma.domain.User;
import com.projeto.farma.exception.CpfJaExisteException;
import com.projeto.farma.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository repository;

    User user;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        user = new User("nome", "sobrenome", "01234567891", "departamento");
    }

    @Test
    public void testPostUser() throws CpfJaExisteException {
        when(repository.existsByCpf(anyString())).thenReturn(false);
        when(repository.save(any(User.class))).thenReturn(user);
        assertNotNull(userService.postUser(user));
    }

    @Test(expected = CpfJaExisteException.class)
    public void testPostUserCpfJaExiste() throws CpfJaExisteException {
        when(repository.existsByCpf(anyString())).thenReturn(true);
        userService.postUser(user);
    }

    @Test
    public void testFindAllUsers(){
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(repository.findAll()).thenReturn(userList);
        assertEquals(userService.findAllUsers().get(0), user);
    }

    @Test
    public void testFindByDepartamento(){
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(repository.findByDepartamento(anyString())).thenReturn(userList);
        assertEquals(userService.findByDepartamento("departamento").get(0), user);
    }

    @Test
    public void testDeleteUser(){
        userService.deleteUser("idTest");
        verify(repository, times(1)).deleteById(anyString());
    }


}
