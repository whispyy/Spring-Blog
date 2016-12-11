package blog.repositories;

import blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by jf on 11/12/16.
 */
@Repository
public interface PostRepository extends JpaRepository<Post,Long>{
    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.author ORDER BY p.date DESC")
    List<Post> findLatest5posts(Pageable pageable);
}
