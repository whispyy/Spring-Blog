package blog.repositories;

import blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jf on 11/12/16.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
