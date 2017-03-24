package mapper;

import dto.UserPostDto;
import entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface UserPostMapper {

    UserPostDto toUserPostDto(User user);

    User toUser(UserPostDto userPostDto);

}
