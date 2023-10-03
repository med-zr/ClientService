package org.operationsix.ClientService.Repository;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import org.operationsix.ClientService.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class UserRepoTest {

    @Autowired
    private UserRepo userRepo;

    @BeforeEach
    void setUp() {
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
    void testFindByUserName() {
        String username = "medZR";
        String email = "med.zr@gmail.com";
        String testEmail = userRepo.findByUserName(username).getEmail();
        assertThat(testEmail).isEqualTo(email);

    }

    @Test
    void testFindByEmail() {
        String username = "medZR";
        String email = "med.zr@gmail.com";
        String testUsername = userRepo.findByEmail(email).getUserName();
        assertThat(testUsername).isEqualTo(username);
    }
}