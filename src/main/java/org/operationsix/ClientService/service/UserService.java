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
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService{
    private final UserRepo userRepository;
    @Override
    public List<UserVO> getAllUsers() {

        return userRepository.findAll().stream()
                .filter(user -> (!user.isAdmin()&& user.isActive()))
                .sorted(Comparator.comparingLong(User::getIdUser))
                .map(UserToUserVOMappingProfile::map)
                .collect(Collectors.toList());
    }

    @Override
    public UserVO getUserById(Long id) {
        if(userRepository.findById(id).isPresent()){
            return UserToUserVOMappingProfile.map(userRepository.findById(id).get());
        }else{
            log.info("User does not exist");
            return null;
        }

    }

    @Override
    public UserVO getUserByUserName(String username) {
        User user = userRepository.findByUserName(username);
        if (user == null) return null;
        return UserToUserVOMappingProfile.map(user);
    }

    @Override
    public UserVO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) return null;
        return UserToUserVOMappingProfile.map(userRepository.findByEmail(email));
    }

    public UserVO createUser(User user){
        LocalDateTime date = LocalDateTime.now();
        user.setCreateDate(date);
        User createdUser = userRepository.save(user);

        return UserToUserVOMappingProfile.map(user);
    }

    @Override
    public UserVO updateUser(User user) {
        LocalDateTime date = LocalDateTime.now();
        user.setEditDate(date);
        return UserToUserVOMappingProfile.map(userRepository.save(user));
    }

    @Override
    public Boolean deleteUser(Long userId) throws NoSuchFieldException{
            LocalDateTime date = LocalDateTime.now();
            if(userRepository.findById(userId).isPresent()) {
                User user = userRepository.findById(userId).get();
                user.setEditDate(date);
                user.setActive(false);
                user.setUserName(user.getUserName()+"_deleted");
                user.setEmail(user.getEmail()+"_deleted");
                userRepository.save(user);
                return true;
            }
            else{
                log.info("User does not exist");
                return false;
            }
    }
}
