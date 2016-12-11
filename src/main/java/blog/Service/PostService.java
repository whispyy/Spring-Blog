package blog.Service;

import blog.models.Post;

import java.util.List;

/**
 * Created by jf on 09/12/16.
 */
public interface PostService {
    List<Post> findAll();
    List<Post> findAllDesc();
    Post findById(Long id);
    Post create(Post post);
    Post edit(Post post);
    void deleteById(Long id);
}
