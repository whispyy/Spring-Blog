package blog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by jf on 10/12/16.
 */
public class RegisterForm {
    @Size(min=2, max=30, message = "Trop court ou trop long.")
    private String username;

    @NotNull
    @Size(min=1, max=50)
    private String password;

    @Size(min=2, max=30, message = "Trop court ou trop long.")
    private String fullname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {

        return fullname;
    }

}
