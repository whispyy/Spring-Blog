package blog.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jf on 09/12/16.
 */
@Entity
@Table(name= "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 300)
    private String title;

    @Lob
    @Column(nullable=false)
    private String body;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User author;

    @Column(nullable=false)
    private Date date = new Date();

    public Post(long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = user;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public User getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Post() { }

    public Post(Long id, String title, String body, User author, Date date) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
        this.date = date;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
