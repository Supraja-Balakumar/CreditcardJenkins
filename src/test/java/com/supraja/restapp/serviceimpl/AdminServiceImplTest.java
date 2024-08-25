package com.supraja.restapp.serviceimpl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.supraja.restapp.model.Admin;
import com.supraja.restapp.repoimpl.AdminRepoimpl;

public class AdminServiceImplTest {

    @Mock
    private AdminRepoimpl adminRepo;

    @InjectMocks
    private AdminServiceImpl adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void testAddAdmin() {
//        Admin admin = new Admin(1, "John Doe", "john.doe@example.com", "password123");
//
//        when(adminRepo.save(admin)).thenReturn(admin);
//
//        String result = adminService.addAdmin(admin);
//        assertEquals("AddSuccess", result);
//
//        verify(adminRepo, times(1)).save(admin);
//    }

    @Test
    void testGetAdmin() {
        Admin admin = new Admin(1, "John Doe", "john.doe@example.com", "password123");

        when(adminRepo.findById(1)).thenReturn(admin);

        Admin result = adminService.getAdmin(1);
        assertNotNull(result);
        assertEquals(1, result.getAdminid());
        assertEquals("John Doe", result.getAdminname());

        verify(adminRepo, times(1)).findById(1);
    }

    @Test
    void testGetAllAdmin() {
        Admin admin1 = new Admin(1, "John Doe", "john.doe@example.com", "password123");
        Admin admin2 = new Admin(2, "Jane Doe", "jane.doe@example.com", "password456");

        when(adminRepo.findAll()).thenReturn(Arrays.asList(admin1, admin2));

        List<Admin> result = adminService.getAllAdmin();
        assertNotNull(result);
        assertEquals(2, result.size());

        verify(adminRepo, times(1)).findAll();
    }

//    @Test
//    void testUpdateAdmin() {
//        Admin admin = new Admin(1, "John Doe", "john.doe@example.com", "password123");
//
//        when(adminRepo.save(admin)).thenReturn(admin);
//
//        adminService.updateAdmin(admin);
//
//        verify(adminRepo, times(1)).save(admin);
//    }

    @Test
    void testDeleteAdmin() {
        int adminId = 1;

        adminService.deleteAdmin(adminId);

        verify(adminRepo, times(1)).deleteById(adminId);
    }
}
