package cooksys.controllers;

import cooksys.service.TagService;
import entity.Hashtag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tags")
public class TagController {

    private TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<Hashtag> get() {
        return tagService.get();
    }

    @GetMapping("{label}")
    public Hashtag getHashTag(@PathVariable String label) {
        return tagService.getHashtag(label);
    }
}
