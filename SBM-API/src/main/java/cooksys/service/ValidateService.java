package cooksys.service;

import entity.DeletedUsers;
import entity.User;
import org.springframework.stereotype.Service;
import repository.DeletedUsersRepository;
import repository.HashtagRepository;
import repository.UserRepository;

@Service
public class ValidateService {

    private UserRepository userRepository;
    private HashtagRepository hashtagRepository;
    private DeletedUsersRepository deletedUsersRepository;

    public ValidateService(UserRepository userRepository, HashtagRepository hashtagRepository,
                           DeletedUsersRepository deletedUsersRepository) {
        this.userRepository = userRepository;
        this.hashtagRepository = hashtagRepository;
        this.deletedUsersRepository = deletedUsersRepository;
    }

    public boolean checkHashtag(String tag) {
        return hashtagRepository.findByLabel(tag) != null ? true: false;
    }

    public boolean checkUsername(String username) {
        return userRepository.findByUsername(username) instanceof User ? true: false;
    }

    public boolean checkAvailable(String username) {
        return !(deletedUsersRepository.findByUsername(username) instanceof DeletedUsers)
                && !(userRepository.findByUsername(username) instanceof User) ? true : false;
    }
}
