package repository;

import entity.DeletedUsers;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeletedUsersRepository extends JpaRepository<User, Long> {
    DeletedUsers findByUsername(String username);
}
