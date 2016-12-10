package blog.Service;

import blog.models.User;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by jf on 10/12/16.
 */

@Service
public class UserServiceStubImpl implements UserService{

    @Override
    public boolean authentificate(String username, String password) {
        //replace with db when actived
        return Objects.equals(username,password);
    }
}
