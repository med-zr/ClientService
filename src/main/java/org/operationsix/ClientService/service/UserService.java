package org.operationsix.ClientService.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.operationsix.ClientService.Repository.UserRepo;
import org.operationsix.ClientService.Utils.UserToUserVOMappingProfile;
import org.operationsix.ClientService.dto.UserVO;
import org.operationsix.ClientService.models.User;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService{
    private final UserRepo userRepository;
    @Override
    public List<UserVO> getAllUsers() {

        return userRepository.findAll().stream()
                .sorted(Comparator.comparingLong(User::getId))
                .map(UserToUserVOMappingProfile::map).collect(Collectors.toList());
    }

    @Override
    public UserVO getUserById(Long id) {
        //Todo: implement Try/Catch
        return UserToUserVOMappingProfile.map(userRepository.findById(id).get());
    }

    @Override
    public UserVO getUserByUsername(String username) {
        return UserToUserVOMappingProfile.map(userRepository.findByUsername(username));
    }

    @Override
    public UserVO getUserByEmail(String email) {
        return UserToUserVOMappingProfile.map(userRepository.findByEmail(email));
    }

    public UserVO createUser(User user){
        User createdUser = userRepository.save(user);

        return UserToUserVOMappingProfile.map(user);
    }

    @Override
    public UserVO updateUser(User user) {
        return UserToUserVOMappingProfile.map(userRepository.save(user));
    }

    @Override
    public Boolean deleteUser(Long userId) {
        //Todo : Tomorrow morning
        User user = userRepository.findById(userId).get();
        user.setIsActive(0);
        //user.setUsername();
        return null;
    }
}