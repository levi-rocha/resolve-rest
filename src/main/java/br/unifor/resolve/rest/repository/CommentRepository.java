package br.unifor.resolve.rest.repository;

import br.unifor.resolve.rest.entity.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "comment", exported = false)
public interface CommentRepository extends
        PagingAndSortingRepository<Comment, Long> {

    Comment findById(Long id);

    Comment deleteById(Long id);

    Comment save(Comment comment);

}
