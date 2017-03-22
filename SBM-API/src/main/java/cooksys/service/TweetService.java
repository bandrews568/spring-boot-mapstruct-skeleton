package cooksys.service;

import dto.TweetDto;
import entity.Tweet;
import mapper.TweetMapper;
import org.springframework.stereotype.Service;
import repository.TweetRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TweetService {

    private TweetRepository tweetRepository;
    private TweetMapper tweetMapper;

    public TweetService(TweetRepository tweetRepository, TweetMapper tweetMapper) {
        this.tweetRepository = tweetRepository;
        this.tweetMapper = tweetMapper;
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
        return tweetMapper.toTweetDto(tweetRepository.save(tweet));
    }

    public TweetDto delete(Long id) {
        Tweet tweet = tweetRepository.getOne(id);
        tweetRepository.delete(id);
        return tweetMapper.toTweetDto(tweet);
    }
}
