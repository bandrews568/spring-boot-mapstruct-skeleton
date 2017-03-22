package cooksys.controllers;

import cooksys.service.TweetService;
import dto.TweetDto;
import entity.Tweet;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tweets")
public class TweetController {

    private TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping
    public List<TweetDto> index() {
        return tweetService.index();
    }

    @GetMapping("{id}")
    public TweetDto getTweet(@PathVariable Long id) {
        return tweetService.getTweet(id);
    }

    @PostMapping
    public TweetDto post(@RequestBody @Validated Tweet tweet) {
        return tweetService.post(tweet);
    }

    @DeleteMapping("{id}")
    public TweetDto delete(@PathVariable Long id) {
        tweetService.delete(id);
    }

}
