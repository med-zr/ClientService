package org.operationsix.ClientService.service;

import org.operationsix.ClientService.dto.UserVO;
import org.operationsix.ClientService.models.User;

import java.util.List;

public interface IUserService {
    public List<UserVO> getAllUsers();
    public UserVO getUserById(Long id);
    public UserVO getUserByUsername(String username);
    public UserVO getUserByEmail(String email);
    public UserVO createUser(User user);
    public UserVO updateUser(User user);

    public Boolean deleteUser(Long userId);
}
