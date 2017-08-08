package com.example.myapp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "post", path = "posts")
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    Page<Post> findAll(Pageable pageable);

    Post save(Post post);

    void deleteById(Long id);

}
