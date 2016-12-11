package blog.Service;

import blog.models.User;

import java.util.List;

/**
 * Created by jf on 10/12/16.
 */
public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User create(User user);
    User edit(User user);
    void deleteById(Long id);
}
