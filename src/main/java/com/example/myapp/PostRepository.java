package com.example.myapp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "post", exported = false)
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    Post findById(Long id);

    Page<Post> findAll(Pageable pageable);

    Post save(Post post);

    void deleteById(Long id);

}
