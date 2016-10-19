package hello.service;

import hello.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jyi
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
}
