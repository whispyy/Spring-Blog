package blog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by jf on 11/12/16.
 */
public class addPostForm {

    @Size(min=2, max=30, message = "Username size should be in the range [2...30]")
    private String title;

    @NotNull
    @Size(min=1, max=50)
    private String body;

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
