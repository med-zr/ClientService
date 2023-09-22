package org.operationsix.ClientService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.operationsix.ClientService.dto.UserVO;
import org.operationsix.ClientService.models.User;
import org.operationsix.ClientService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<UserVO> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserVO createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/byId")
    @ResponseStatus(HttpStatus.OK)
    public UserVO userById(@RequestParam(name = "id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/byEmail")
    @ResponseStatus(HttpStatus.OK)
    public UserVO userByEmail(@RequestParam(name = "email") String email){
        return userService.getUserByEmail(email);
    }

    @GetMapping("/byUsername")
    @ResponseStatus(HttpStatus.OK)
    public UserVO userByUsername(@RequestParam(name = "username") String username){
        return userService.getUserByUsername(username);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UserVO updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> deleteUser(@RequestParam(name = "id") Long id){
        return userService.deleteUser(id)? ResponseEntity.status(HttpStatus.OK).body("User : "+id+" has been successfully deleted"):ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error in deletion : User not found");
    }
}
