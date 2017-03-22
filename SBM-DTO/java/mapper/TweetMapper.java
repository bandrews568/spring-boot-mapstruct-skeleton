package mapper;

import dto.TweetDto;
import entity.Tweet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TweetMapper {

    TweetDto toTweetDto(Tweet tweet);
}
