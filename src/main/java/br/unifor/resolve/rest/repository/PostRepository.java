package br.unifor.resolve.rest.repository;

import br.unifor.resolve.rest.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@RepositoryRestResource(collectionResourceRel = "post", exported = false)
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    Post findById(Long id);

    @Transactional
    Long deleteById(Long id);

    Page<Post> findAll(Pageable pageable);

    Post save(Post post);

    List<Post> findDistinctByContentContainingIgnoreCaseOrTitleContainingIgnoreCase(
            String content, String title);

    Page<Post> findByIdIn(Pageable pageable, List<Long> ids);

    List<Post> findDistinctByAuthorId(Long authorId);
    Page<Post> findDistinctByAuthorId(Pageable pageable, Long authorId);

}
