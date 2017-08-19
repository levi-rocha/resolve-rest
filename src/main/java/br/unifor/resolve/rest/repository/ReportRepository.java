package br.unifor.resolve.rest.repository;

import br.unifor.resolve.rest.entity.Report;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "report", exported = false)
public interface ReportRepository extends
        PagingAndSortingRepository<Report, Long> {

    Report findById(Long id);

    Report deleteById(Long id);

}
