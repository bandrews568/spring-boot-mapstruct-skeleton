package cooksys.service;

import dto.TweetDto;
import dto.UserDto;
import entity.Credentials;
import entity.DeletedUsers;
import entity.Tweet;
import entity.User;
import mapper.TweetMapper;
import mapper.UserMapper;
import org.springframework.stereotype.Service;
import repository.CredentialsRepository;
import repository.DeletedUsersRepository;
import repository.TweetRepository;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private CredentialsRepository credentialsRepository;
    private UserMapper userMapper;
    private DeletedUsersRepository deletedUsersRepository;
    private TweetRepository tweetRepository;
    private TweetMapper tweetMapper;

    public UserService(UserRepository userRepository, CredentialsRepository credentialsRepository,
                       UserMapper userMapper, DeletedUsersRepository deletedUsersRepository,
                       TweetRepository tweetRepository, TweetMapper tweetMapper) {
        this.userRepository = userRepository;
        this.credentialsRepository = credentialsRepository;
        this.userMapper = userMapper;
        this.deletedUsersRepository = deletedUsersRepository;
        this.tweetRepository = tweetRepository;
        this.tweetMapper = tweetMapper;
    }

    public List<UserDto> index() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    public UserDto post(User user) {
        UserDto userDto = null;

        if (!userExist(user.getUsername(), user.getPassword())) {
            userDto = userMapper.toUserDto(userRepository.save(user));
        }
        return userDto;
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User patch(User user) {
        if (userExist(user.getUsername(), user.getPassword())){
            return userRepository.save(user);
        }
        return null; // TODO return error
    }

    public User delete(String username) {
        User user = userRepository.findByUsername(username);
        if (!(user instanceof User)) {
            userRepository.delete(user);
            deletedUsersRepository.save(user);
        }
        return user;
    }

    public void follow(String username, User user) {
        if (userExist(user.getUsername(), user.getPassword())) {
            User getUser = userRepository.findByUsername(user.getUsername());
            getUser.setFollowerSet(userRepository.findByUsername(username));
        }
        // TODO error handling
    }

    public void unfollow(String username, User user) {
        if (userExist(user.getUsername(), user.getPassword())) {
            User getUser = userRepository.findByUsername(user.getUsername());
            getUser.removeFromFollowers(userRepository.findByUsername(username));
        }
        // TODO error handling
    }

    public List<TweetDto> getTweets(String username) {
        List<TweetDto> tweetDtos = new ArrayList<>();

        for (Tweet tweet : tweetRepository.findByAuthor(username)) {
            tweetDtos.add(tweetMapper.toTweetDto(tweet));
        }
        return tweetDtos;
    }

    public List<String> getFollowers(String username) {
        List<String> followers = new ArrayList<>();
        User user = userRepository.findByUsername(username);
        for (User follower : user.getFollowerSet()) {
            followers.add(follower.getUsername());
        }
        return followers;
    }

    public List<String> getFollowing(String username) {
        List<String> following = new ArrayList<>();
        User user = userRepository.findByUsername(username);
        for (User follower : user.getFollowerSet()) {
            following.add(follower.getUsername());
        }
        return following;
    }

    private boolean userExist(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)  instanceof User ? true : false;
    }
}
