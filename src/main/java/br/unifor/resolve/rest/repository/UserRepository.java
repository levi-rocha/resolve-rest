package br.unifor.resolve.rest.repository;

import br.unifor.resolve.rest.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(collectionResourceRel = "user", exported = false)
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Page<User> findAll(Pageable pageable);

    User findByUsername(@Param("username") String username);

    User save(User user);

    @Transactional
    Long deleteByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    boolean existsByEmail(String email);

}
