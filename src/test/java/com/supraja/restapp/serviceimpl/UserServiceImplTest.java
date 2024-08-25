package com.supraja.restapp.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.supraja.restapp.model.User;
import com.supraja.restapp.repository.UserRepo;
import com.supraja.restapp.service.UserService;

public class UserServiceImplTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddUser() {
        User user = new User(1, "John Doe", "01-01-1990", "New York", "john.doe@example.com", "1234567890", "password");

        when(userRepo.save(user)).thenReturn(user);

        User result = userService.addUser(user);
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("John Doe", result.getName());

        verify(userRepo, times(1)).save(user);
    }

//    @Test
//    void testGetUser() {
//        User user = new User(1, "John Doe", "01-01-1990", "New York", "john.doe@example.com", "1234567890", "password");
//
//        when(userRepo.findById(1)).thenReturn(Optional.of(user));
//
//        User result = userService.getUser(1);
//        assertNotNull(result);
//        assertEquals(1, result.getId());
//        assertEquals("John Doe", result.getName());
//
//        verify(userRepo, times(1)).findById(1);
//    }

    @Test
    void testGetAllUser() {
        User user1 = new User(1, "John Doe", "01-01-1990", "New York", "john.doe@example.com", "1234567890", "password");
        User user2 = new User(2, "Jane Doe", "02-02-1992", "Los Angeles", "jane.doe@example.com", "0987654321", "password");

        when(userRepo.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> result = userService.getAllUser();
        assertNotNull(result);
        assertEquals(2, result.size());

        verify(userRepo, times(1)).findAll();
    }

    @Test
    void testUpdateUser() {
        User user = new User(1, "John Doe", "01-01-1990", "New York", "john.doe@example.com", "1234567890", "password");

        when(userRepo.save(user)).thenReturn(user);

        userService.updateUser(user);

        verify(userRepo, times(1)).save(user);
    }

    @Test
    void testDeleteUser() {
        int userId = 1;

        userService.deleteUser(userId);

        verify(userRepo, times(1)).deleteById(userId);
    }

    @Test
    void testGetAllId() {
        List<Integer> ids = Arrays.asList(1, 2, 3);

        when(userRepo.getIDList()).thenReturn(ids);

        List<Integer> result = userService.getAllId();
        assertNotNull(result);
        assertEquals(3, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));

        verify(userRepo, times(1)).getIDList();
    }

    @Test
    void testFindByEmail() {
        User user = new User(1, "John Doe", "01-01-1990", "New York", "john.doe@example.com", "1234567890", "password");

        when(userRepo.findByEmail("john.doe@example.com")).thenReturn(user);

        User result = userService.findByEmail("john.doe@example.com");
        assertNotNull(result);
        assertEquals("john.doe@example.com", result.getEmail());

        verify(userRepo, times(1)).findByEmail("john.doe@example.com");
    }
}
