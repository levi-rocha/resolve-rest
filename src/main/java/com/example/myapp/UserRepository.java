package com.example.myapp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Page<User> findAll(Pageable pageable);

    User findById(@Param("id") Long id);

    User findByUsername(@Param("username") String username);

    User save(User user);

    void deleteById(@Param("id") Long id);

    @RestResource(exported = false)
    User findByUsernameAndPassword(String username, String password);

}
