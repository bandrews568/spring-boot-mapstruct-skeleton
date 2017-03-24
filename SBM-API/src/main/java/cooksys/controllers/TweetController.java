package cooksys.controllers;

import cooksys.service.TweetService;
import dto.TweetDto;
import entity.Hashtag;
import entity.Tweet;
import entity.User;
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

    @GetMapping("{id}/likes")
    public List<String> getLikers(@PathVariable Long id) {
        return tweetService.getLikers(id);
    }

    @GetMapping("@{username}/tweets")
    public List<TweetDto> getTweets(@PathVariable String username) {
        return tweetService.getTweets(username);
    }

    @GetMapping("{id}/tags")
    public List<String> getTags(@PathVariable Long id) {
        return tweetService.getTags(id);
    }

    @PostMapping("{id}/like")
    public void likeTweet(@PathVariable Long id, @RequestBody User user) {
        tweetService.likeTweet(id, user);
    }

    @PostMapping
    public TweetDto post(@RequestBody @Validated Tweet tweet) {
        return tweetService.post(tweet);
    }

    @DeleteMapping("{id}")
    public TweetDto delete(@PathVariable Long id) {
        return tweetService.delete(id);
    }

}
