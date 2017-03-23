package cooksys.service;

import entity.Hashtag;
import org.springframework.stereotype.Service;
import repository.HashtagRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    private HashtagRepository hashtagRepository;

    public TagService(HashtagRepository hashtagRepository) {
        this.hashtagRepository = hashtagRepository;
    }

    public List<Hashtag> get() {
        return hashtagRepository
                .findAll()
                .stream()
                .collect(Collectors.toList());
    }

    public Hashtag getHashtag(String tag) {
        return hashtagRepository.findByLabel(tag);
    }
}
