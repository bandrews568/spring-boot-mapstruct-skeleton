package cooksys.controllers;

import cooksys.service.UserService;
import dto.TweetDto;
import dto.UserDto;
import dto.UserPostDto;
import org.dom4j.util.UserDataDocumentFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import entity.User;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> index() {
        return userService.index();
    }

    @GetMapping("@{username}")
    public User get(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    @GetMapping("@{username}/tweets")
    public List<TweetDto> getTweets(@PathVariable String username) {
        return userService.getTweets(username);
    }

    @GetMapping("@{username}/followers")
    public List<String> getFollowers(@PathVariable String username) {
        return userService.getFollowers(username);
    }

    @GetMapping("@{username}/following")
    public List<String> getFollowing(@PathVariable String username) {
        return userService.getFollowing(username);
    }

    @PostMapping
    public UserPostDto post(@RequestBody @Validated UserPostDto user) {
        return userService.post(user);
    }

    @PostMapping("@{username}/follow")
    public void follow(@PathVariable String username, @RequestBody User user) {
        userService.follow(username, user);
    }

    @PostMapping("@{username}/unfollow")
    public void unfollow(@PathVariable String username, @RequestBody User user) {
        userService.unfollow(username, user);
    }

    @PatchMapping("@{username}")
    public User patch(@RequestBody @Validated User username) {
        return userService.patch(username);
    }

    @DeleteMapping("@{username}")
    public User delete(@PathVariable String username) {
        return userService.delete(username);
    }
}
