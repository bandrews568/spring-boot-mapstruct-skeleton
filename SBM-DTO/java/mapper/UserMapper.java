package mapper;

import dto.UserDto;
import entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

}
