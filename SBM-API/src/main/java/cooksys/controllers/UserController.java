package cooksys.controllers;

import cooksys.service.UserService;
import dto.UserDto;
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

    @PostMapping
    public User post(@RequestBody @Validated User user) {
        return userService.post(user);
    }

    @PatchMapping("@{username}")
    public User patch(@RequestBody @Validated User username) {
        return userService.patch(username);
    }

    @DeleteMapping("@{username}")
    public User delete(@RequestBody @Validated User username) {
        return userService.delete(username);
    }
}
