package cooksys.controllers;

import cooksys.service.ValidateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("validate")
public class ValidateController {

    private ValidateService validateService;

    public ValidateController(ValidateService validateService) {
        this.validateService = validateService;
    }

    @GetMapping("tag/exists/{label}")
    public boolean getHashtag(@PathVariable String label) {
        return validateService.checkHashtag(label);
    }

    @GetMapping("username/exists/@{username}")
    public boolean getUsername(@PathVariable String username) {
        return validateService.checkUsername(username);
    }

    @GetMapping("username/available/@{username}")
    public boolean checkAvailable(@PathVariable String username) {
        return validateService.checkAvailable(username);
    }
}
