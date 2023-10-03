package org.operationsix.ClientService.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.operationsix.ClientService.Repository.UserRepo;
import org.operationsix.ClientService.dto.UserVO;
import org.operationsix.ClientService.models.User;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepo userRepo;
    private IUserService userService;



    @BeforeEach
    void setUp() {
        userService = new UserService(userRepo);
        User user = new User();
        LocalDateTime date = LocalDateTime.now();
        String username = "medZR";
        String email = "med.zr@gmail.com";
        user.setUserName(username);
        user.setEmail(email);
        user.setActive(true);
        user.setAdmin(false);
        user.setPassword("password");
        user.setCreateDate(date);

        userRepo.save(user);
    }

    @AfterEach
    void tearDown() {
        userRepo.deleteAll();
    }

    @Test
    void testGetAllUsers() {
        //when
        userService.getAllUsers();
        //then
        verify(userRepo).findAll();
    }

    @Test
    void testGetUserById() {
        //given
        Long userID = 1L;
        //when
        userService.getUserById(userID);
        //then
        verify(userRepo).findById(userID);
    }

    @Test
    void testGetUserByUserName() {
        // given
        String username = "medZR";

        // when
        UserVO result = userService.getUserByUserName(username);

        // then
        verify(userRepo).findByUserName(username);
    }

    @Test
    void testGetUserByEmail() {
        // given
        String email = "med.zr@gmail.com";

        // when
        UserVO result = userService.getUserByEmail(email);

        // then
        verify(userRepo).findByEmail(email);
    }

    @Test
    @Disabled
    void testCreateUser() {
    }

    @Test
    @Disabled
    void testUpdateUser() {
    }

    @Test
    @Disabled
    void testDeleteUser() {
    }
}