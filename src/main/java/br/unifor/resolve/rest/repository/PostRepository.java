package br.unifor.resolve.rest.repository;

import br.unifor.resolve.rest.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "post", exported = false)
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    Post findById(Long id);

    @Transactional
    Long deleteById(Long id);

    Page<Post> findAll(Pageable pageable);

    List<Post> findByContentContainingIgnoreCaseOrTitleContainingIgnoreCase(
            String title, String content);

    Post save(Post post);

    Page<Post> findByAuthorId(Pageable pageable, Long authorId);

}
