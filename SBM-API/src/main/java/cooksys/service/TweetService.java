package cooksys.service;

import dto.TweetDto;
import entity.Hashtag;
import entity.Tweet;
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

    public TweetDto post(Tweet tweet) {
        List<String> hashtags = parseHashtag(tweet.getContent());
        for (String tag : hashtags) {
            Hashtag hashtag = new Hashtag();
            hashtag.setLabel(tag);
            hashtag.setFirstUsed(System.currentTimeMillis());
            hashtagRepository.save(hashtag);
        }
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
