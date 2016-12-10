package blog.Service;

import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by jf on 10/12/16.
 */

@Service
public class UserServiceStubImpl implements UserService{

    @Override
    public boolean authentificate(String username, String password) {
        return Objects.equals(username,password);
    }
}
