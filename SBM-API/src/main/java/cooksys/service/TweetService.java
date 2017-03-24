package cooksys.service;

import dto.TweetDto;
import entity.Hashtag;
import entity.Tweet;
import entity.User;
import mapper.TweetMapper;
import org.springframework.stereotype.Service;
import repository.HashtagRepository;
import repository.TweetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TweetService {

    private TweetRepository tweetRepository;
    private TweetMapper tweetMapper;
    private HashtagRepository hashtagRepository;

    public TweetService(TweetRepository tweetRepository, TweetMapper tweetMapper, HashtagRepository hashtagRepository) {
        this.tweetRepository = tweetRepository;
        this.tweetMapper = tweetMapper;
        this.hashtagRepository = hashtagRepository;
    }

    public List<TweetDto> index() {
        return tweetRepository
                .findAll()
                .stream()
                .map(tweetMapper::toTweetDto)
                .collect(Collectors.toList());
    }

    public TweetDto getTweet(Long id) {
        return tweetMapper.toTweetDto(tweetRepository.getOne(id));
    }

    public List<String> getTags(Long id) {
        return tweetRepository.getOne(id).getHashtags();
    }

    public List<TweetDto> getTweets(String username) {
        List<Tweet> tweetList = tweetRepository.findByAuthor(username);
        List<TweetDto> tweetDtos = new ArrayList<>();
        for (Tweet tweet : tweetList) {
            tweetDtos.add(tweetMapper.toTweetDto(tweet));
        }
        return tweetDtos;
    }

    public List<String> getLikers(Long id) {
        List<User> likersList = tweetRepository.getOne(id).getLikers();
        List<String> likers = new ArrayList<>();

        for (User user : likersList) {
            likers.add(user.getUsername());
        }
        return likers;
    }

    public void likeTweet(Long id, User user) {
        tweetRepository.getOne(id).addLiker(user);
    }

    public TweetDto post(Tweet tweet) {
        List<String> hashtags = parseHashtag(tweet.getContent());
        for (String tag : hashtags) {
            Hashtag hashtag = new Hashtag();
            hashtag.setLabel(tag);
            hashtag.setFirstUsed(System.currentTimeMillis());
            hashtagRepository.save(hashtag);
        }
        tweet.setHashtags(hashtags);
        return tweetMapper.toTweetDto(tweetRepository.save(tweet));
    }

    public TweetDto delete(Long id) {
        Tweet tweet = tweetRepository.getOne(id);
        tweetRepository.delete(id);
        return tweetMapper.toTweetDto(tweet);
    }

    public List<String> parseHashtag(String content) {
        String[] words = content.split(" ");
        List<String> hashtags = new ArrayList<>();

        for (String word : words) {
            if (word.startsWith("#") && word.length() > 1) {
                hashtags.add(word);
            }
        }
        return hashtags;
    }
}
