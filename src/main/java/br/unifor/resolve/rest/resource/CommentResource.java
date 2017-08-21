package br.unifor.resolve.rest.resource;

import br.unifor.resolve.rest.entity.Comment;
import br.unifor.resolve.rest.dto.CommentUpdateFields;
import br.unifor.resolve.rest.dto.CommentDTO;
import br.unifor.resolve.rest.entity.User;
import br.unifor.resolve.rest.repository.CommentRepository;
import br.unifor.resolve.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentResource {

    private CommentRepository commentRepository;
    private UserRepository userRepository;

    @Autowired
    public CommentResource(CommentRepository commentRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(method = GET)
    public List<CommentDTO> findAll(Pageable pageable) {
        List<Comment> data =
                commentRepository.findAll(pageable).getContent();
        List<CommentDTO> dtos = new ArrayList<>();
        for (Comment c : data) {
            dtos.add(CommentDTO.fromComment(c));
        }
        return dtos;
    }

    @RequestMapping(value = "/{id}", method = GET)
    public CommentDTO findById(
            @PathVariable Long id) {
        return CommentDTO.fromComment(commentRepository.findById(id));
    }

    @RequestMapping(method = POST)
    public CommentDTO insert(@RequestBody Comment comment) {
        User author = userRepository.findByUsername(
                comment.getAuthor().getUsername());
        comment.setAuthor(author);
        return CommentDTO.fromComment(commentRepository.save(comment));
    }

    @RequestMapping(value = "/{id}", method = PATCH)
    public CommentDTO update(@RequestBody CommentUpdateFields comment,
                                  @PathVariable Long id) {
        Comment found = commentRepository.findById(id);
        if (found == null)
            return null;
        if (comment.getContent() != null)
            found.setContent(comment.getContent());
        return CommentDTO.fromComment(commentRepository.save(found));
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public CommentDTO delete(@PathVariable Long id) {
        return CommentDTO.fromComment(commentRepository
                .deleteById(id));
    }

}
