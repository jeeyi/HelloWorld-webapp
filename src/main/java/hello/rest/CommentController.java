package hello.rest;

import hello.entity.Comment;
import hello.service.CommentRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jyi
 */
@RestController
public class CommentController {
    
    static Logger logger = getLogger(CommentController.class);
    
    @Autowired
    CommentRepository commentRepository;

    @ApiOperation(value = "getComments", nickname = "getComments")
    @RequestMapping(method = RequestMethod.GET, path = "/comment", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = List.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure")})
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }
    
    @ApiOperation(value = "postComment", nickname = "postComment")
    @RequestMapping(method = RequestMethod.POST, path = "/comment", consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Created", response = Comment.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure")})
    public Comment postComment(@RequestBody Comment comment) {
        logger.info("comment={}", comment.getContent());
        return commentRepository.save(comment);
    }
}
