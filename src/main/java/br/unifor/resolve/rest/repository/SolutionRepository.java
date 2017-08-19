package br.unifor.resolve.rest.repository;

import br.unifor.resolve.rest.entity.Solution;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "solution", exported = false)
public interface SolutionRepository extends
        PagingAndSortingRepository<Solution, Long> {

    Solution findById(Long id);

    Solution deleteById(Long id);

}
