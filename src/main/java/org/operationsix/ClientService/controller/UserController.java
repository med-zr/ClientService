package org.operationsix.ClientService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.operationsix.ClientService.dto.UserVO;
import org.operationsix.ClientService.models.User;
import org.operationsix.ClientService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserVO> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/createuser")
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
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@RequestParam(name = "id") Long id){
        return userService.deleteUser(id)? "User successfully deleted":"Error in deletion";
    }
}
