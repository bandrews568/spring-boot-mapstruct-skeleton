package cooksys.service;

import dto.UserDto;
import entity.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDto> index() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    public User post(User user) {
        return userRepository.save(user);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User patch(User user) {
        return userRepository.save(user);
    }

    public User delete(User user) {
        userRepository.delete(user.getId());
        // TODO move in to another table after deleting
        return user;
    }
}
