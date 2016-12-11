package blog.Service;

import blog.models.Post;
import blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jf on 11/12/16.
 */

@Service
@Primary
public class PostServiceJpaImpl implements PostService{

    @Autowired
    private PostRepository postRepo;

    @Override
    public List<Post> findAll() {
        return this.postRepo.findAll();
    }

    @Override
    public Post findById(Long id) {
        return this.postRepo.findOne(id);
    }

    @Override
    public Post create(Post post) {
        return this.postRepo.save(post);
    }

    @Override
    public Post edit(Post post) {
        return this.postRepo.save(post);
    }

    @Override
    public void deleteById(Long id) {
        this.postRepo.delete(id);
    }
}
